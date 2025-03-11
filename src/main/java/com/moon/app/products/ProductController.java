package com.moon.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.moon.app.pages.Pager;
import com.moon.app.users.UserDTO;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Model -> 
	 * requestScope 와 라이프사이클이 비슷
	 * 응답이 발생하면 소멸
	 * request와 비슷한 일을 함
	 * java -> jsp로 데이터를 전달 할 때 사용
	 * 
	 */
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		List<ProductDTO> ar = productService.getList(pager);
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
		return "products/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getDetail(productDTO);
		ModelAndView mv = new ModelAndView();
		//model
		mv.addObject("dto", productDTO);
		//view
		mv.setViewName("products/detail");
//		model.addAttribute("dto", productDTO);
		
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv) throws Exception {
		
		mv.setViewName("products/add");
		return mv;
//		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO, Model model) throws Exception {
		/**
		 * 파라미터 처리 방법
		 * 1. 모든 요청 정보는 Request에 있다.(URL, METHOD, PARAMETER, COOKIE...)
		 * 	메서드의 매개변수로 HttpServletRequest request 선언
		 * 	request.getParameter("")
		 * 
		 * 2. 매개변수로 파라미터이름과 동일한 변수명, 동일한 타입명을 선언
		 * 
		 * 3. 매개변수로 Bean(DTO)를 선언
		 * 	파라미터의 이름과 타입이 DTO의 Setter의 이름과 동일
		 */
		
		int result = productService.add(productDTO);
		
		String str = "상품 등록 실패";
		if(result > 0) {
			str = "상품 등록 성공";
		}
		
		model.addAttribute("result", str);
		model.addAttribute("path", "./list");
		
		return "commons/result";
//		return "redirect:./list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getDetail(productDTO);
		
		model.addAttribute("dto", productDTO);
		
		return "products/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO productDTO) throws Exception {
		int result = productService.update(productDTO);
		
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
		
		return "redirect:./list";
	}
	
	//------------------ Comments ------------------------
	//addComments
	@RequestMapping(value = "addComments", method = RequestMethod.POST)
	public String addComments(CommentsDTO commentsDTO, HttpSession session, Model model)throws Exception{
		
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		commentsDTO.setUserName(userDTO.getUserName());
		
		int result = productService.addComments(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value="listComments", method=RequestMethod.GET)
	public String listComments(Pager pager, CommentsDTO commentsDTO, Model model) throws Exception {
		System.out.println("comments list");
		
		List<CommentsDTO> ar = productService.getCommentList(commentsDTO, pager);
		
		model.addAttribute("list", ar);
		
		return "commons/commentsList";
	}
	
	@RequestMapping(value="deleteComments", method=RequestMethod.GET)
	public String deleteComments(CommentsDTO commentsDTO, Model model, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		commentsDTO.setUserName(userDTO.getUserName());
		
		int result = productService.deleteComments(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
}
