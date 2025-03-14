package com.moon.app.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.PageRanges;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moon.app.files.FileDTO;
import com.moon.app.files.FileManager;
import com.moon.app.pages.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${products.file.path}")
	private String path;
	
	
	//list
	public List<ProductDTO> getList(Pager pager) throws Exception {
//		Pager pager = new Pager();
//		pager.setPage(page);
		
		Long totalCount = productDAO.count(pager);
		
		pager.make(totalCount);
		
		pager.makeNum();
		List<ProductDTO> ar = productDAO.getList(pager);
		
		return ar;
	}
	
	//detail
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		productDTO = productDAO.getDetail(productDTO);
		
		return productDTO;
	}
	
	//add
	public int add(ProductDTO productDTO) throws Exception {
		//dao 호출
		int result = productDAO.add(productDTO);
		
		return result;
	}
	
	//update
	public int update(ProductDTO productDTO) throws Exception {
		int result = productDAO.update(productDTO);
		
		return result;
	}
	
	//delete
	public int delete(ProductDTO productDTO) throws Exception {
		int result = productDAO.delete(productDTO);
		
		return result;
	}
	
	public String detailFiles(HttpSession session, MultipartFile files)throws Exception{
		String path = session.getServletContext().getRealPath("/resources/images/products/");
		System.out.println(path);
		String fileName = FileManager.fileSave(path, files);
		return fileName;
		
	}
	
	public void detailFilesDelete(FileDTO fileDTO, HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/images/products/");
		System.out.println(path);
		fileManager.fileDelete(path, fileDTO.getFileName());
	}
	
	//------------------ Comments ------------------
	public int addComments(CommentsDTO commentsDTO)throws Exception{
		return productDAO.addComments(commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception {
		Long total = productDAO.getCommentsTotalCount(commentsDTO);
		
		pager.make(total);
		pager.makeNum();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		
		List<CommentsDTO> ar = productDAO.getCommentList(map);
		return ar;
	}
	
	public int deleteComments(CommentsDTO commentsDTO) throws Exception {
		return productDAO.deleteComments(commentsDTO);
	}
	
	public int updateComments(CommentsDTO commentsDTO) throws Exception {
		return productDAO.updateComments(commentsDTO);
	}

}
