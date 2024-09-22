package com.ktv.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ktv.model.Category;
import com.ktv.model.CategorySec;
import com.ktv.model.Product;
import com.ktv.service.CategorySecService;
import com.ktv.service.CategoryService;
import com.ktv.service.ProductService;
import com.ktv.utils.Pager;
import com.ktv.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	private Product product;


	@Override
	public Product getModel() {
		if(product==null) product = new Product();
		return product;
	}

	@Autowired
	private ProductService productService;

	@Autowired
	private CategorySecService categorySecService;

	@Autowired
	private CategoryService categoryService;

	//========================图片上传
	private File file;

	//提交过来的file的名字
	private String fileFileName;

	//提交过来的file的MIME类型
	private String fileContentType;


	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	//========================图片上传


	/**
	 * 列表
	 */
	public String product(){
		Pager<Product> pagers = productService.findPager(product);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("product", product);
		return SUCCESS;
	}


	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		String hql="from CategorySec where 1=1 and  isDelete=0";
		List<CategorySec> categorySecList=categorySecService.getByHQL(hql, null);
		ActionContext.getContext().put("categorySecList", categorySecList);
		return SUCCESS;
	}

	/**
	 * 执行添加
	 * @return
	 * @throws FileNotFoundException 
	 */
	public String exAdd() throws Exception{
		//图片上传
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16);
		path = path.replace("_admin", "");
		String root  = path+"/upload";
		InputStream is = new FileInputStream(file);
		fileFileName = UUIDUtils.create()+fileFileName;
		OutputStream os = new FileOutputStream(new File(root, fileFileName));
		System.out.println("fileFileName: " + fileFileName);
		System.out.println("file: " + file.getName());
		System.out.println("file: " + file.getPath());
		byte[] buffer = new byte[500];
		int length = 0;
		while(-1 != (length = is.read(buffer, 0, buffer.length)))
		{
			os.write(buffer);
		}
		os.close();
		is.close();
		product.setImage("\\upload\\"+fileFileName);
		CategorySec cs= categorySecService.getById(product.getCategorySec().getId());
		Category c = categoryService.getById(cs.getCategory().getId());
		product.setCategory(c);
		ActionContext.getContext().put("categorySec", c);
		productService.save(product);
		//	        CarCategory carCategory=carCategoryService.getById(car.getCarCategory().getId());
		//	        carCategory.setCarNumber(carCategory.getCarNumber()+1);
		//	        carCategoryService.update(carCategory);
		ActionContext.getContext().put("url", "/product_product.do");
		return "redirect";
	}

	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		String hql="from CategorySec where 1=1 and  isDelete=0";
		List<CategorySec> categorySecList=categorySecService.getByHQL(hql, null);
		ActionContext.getContext().put("categorySecList", categorySecList);
		Product p = productService.getById(product.getId());
		ActionContext.getContext().put("product", p);
		return SUCCESS;
	}

	/**
	 * 执行修改
	 * @return
	 * @throws FileNotFoundException 
	 */
	public String exUpdate() throws Exception{
		Product p = productService.getById(product.getId());
		if(file!=null){
			//图片上传
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16);
			path = path.replace("_admin", "");
			String root  = path+"/upload";
			InputStream is = new FileInputStream(file);
			fileFileName = UUIDUtils.create()+fileFileName;
			OutputStream os = new FileOutputStream(new File(root, fileFileName));
			System.out.println("fileFileName: " + fileFileName);
			System.out.println("file: " + file.getName());
			System.out.println("file: " + file.getPath());
			byte[] buffer = new byte[500];
			int length = 0;
			while(-1 != (length = is.read(buffer, 0, buffer.length)))
			{
				os.write(buffer);
			}
			os.close();
			is.close();
			p.setImage("\\upload\\"+fileFileName);
		}else{
			p.setImage(p.getImage());
		}
		CategorySec cs= categorySecService.getById(product.getCategorySec().getId());
		Category c = categoryService.getById(cs.getCategory().getId());
		p.setCategory(c);
		p.setCategorySec(product.getCategorySec());
		p.setIsDelete(product.getIsDelete());
		p.setName(product.getName());
		p.setRemark(product.getRemark());
		p.setPrice(product.getPrice());
		productService.update(p);
		ActionContext.getContext().put("url", "/product_product.do");
		return "redirect";
	}


	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		Product p = productService.getById(product.getId());
		p.setIsDelete(1);
		productService.update(p);
		ActionContext.getContext().put("url", "/product_product.do");
		return "redirect";
	}




}
