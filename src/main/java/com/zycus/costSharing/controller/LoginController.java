package com.zycus.costSharing.controller;

import com.zycus.costSharing.models.BaseResponse;
import com.zycus.costSharing.models.Customer;
import com.zycus.costSharing.repositories.CustomerRepo;
import com.zycus.costSharing.reqs.SignInReq;
import com.zycus.costSharing.reqs.SignUpReq;
import com.zycus.costSharing.resps.LoginResp;
import com.zycus.costSharing.utilfunctions.Constants;
import com.zycus.costSharing.utilfunctions.MongoDBSequenceDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {


	@Autowired
	private CustomerRepo customerrepo;

	@Autowired
	private MongoDBSequenceDAO seqDao;


	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/home")
	public String mainpage() {

		return "index";
	}

//	@RequestMapping("/try11")
//	public String mainpage1(Model model) {
//
//		model.addAttribute("title","Hello World!");
//		return "try";
//	}


	@RequestMapping(value = "/signup" ,method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}

	@RequestMapping(value = "/signup" ,method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> signup(@RequestBody SignUpReq req ) {

		BaseResponse br = new BaseResponse();
		Customer customer = customerrepo.findByCustomerEmail(req.getCustomerEmail());
		System.out.println("signup form");
		System.out.println("hi "+req.getCustomerEmail());
		try {
			if(customer == null && req.getCustomerEmail().length() > 0) {
				customer = new Customer();
				BeanUtils.copyProperties(req, customer);
				customer.setCustID(seqDao.getNextSequece(Constants.CUSTOMER_ID));
				customerrepo.save(customer);
				br.setMessage("success");
				br.setResponseCode(200);

			}else {
				br.setMessage("EmailID already Exists ");
				br.setResponseCode(200);
			}
		}catch(Exception e) {
			LOGGER.info("Exception in signup");
		}
		return ResponseEntity.status(HttpStatus.OK).body(br);
	}



	@RequestMapping(value = "/signin" ,method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> signin(@RequestBody SignInReq req ) {

		LoginResp br = new LoginResp();
		System.out.println(req.getCustomerEmail()+""+req.getCustomerPassword());
		
		Customer customerExist = customerrepo.findByCustomerEmail(req.getCustomerEmail());

		try {
			Customer customer = customerrepo.findByCustomerEmailAndCustomerPassword(req.getCustomerEmail(), req.getCustomerPassword());

			if(customer == null) {

				if(customerExist!=null) {
					br.setMessage("Enter password");
					br.setResponseCode(200);
				}else {
					br.setMessage("Customer not available");
					br.setResponseCode(200);
				}
			}else {
				br.setUserId(customer.getCustID());
				br.setMessage("login success");
				br.setResponseCode(200);
			}
		}catch(Exception e) {
			LOGGER.info("Exception in sign in");
		}
		return ResponseEntity.status(HttpStatus.OK).body(br);
	}


	@RequestMapping(value = "/homepage" ,method = RequestMethod.GET)
	public String homepage() {

		return "homepage";
	}

	@RequestMapping("/thanks")
	public String thankspage(Model model) {

		return "thanks";
	}


}
