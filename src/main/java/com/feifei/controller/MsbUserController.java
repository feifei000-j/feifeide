package com.feifei.controller;
import org.springframework.http.ResponseEntity;

import com.feifei.service.MsbUserService;
import com.feifei.entity.MsbUser;
import com.feifei.utils.Result;
import com.feifei.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feifei.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/user")
public class MsbUserController {
	@Autowired
	private MsbUserService userService;

	@GetMapping("/getUserByIdWithoutResult/{userId}")
	public LoginUser getUserByIdWithoutResult(@PathVariable Integer userId) {
		LoginUser userById = userService.selectById(userId);
		if (userById == null) {
			throw new ResourceNotFoundException("用户不存在", 404);
		}
		return userById;
	}



	@GetMapping("/getUserById/{userId}") // 确保这里是 "/getUserById/{userId}"
	public Result<LoginUser> getUserById(@PathVariable Integer userId) {
		LoginUser userById = userService.selectById(userId);
		if (userById == null) {
			return Result.fail("用户不存在", 404);
		}
		return Result.success(userById);
	}

//	@GetMapping("/getUserByIdWithRules/{userId}")
//	public Result<LoginUser> getUserByIdWithRules(@PathVariable Integer userId) {
//		Result<LoginUser> result = userService.selectById(userId);
//		if (result.isSuccess()) {
//			return result;
//		} else {
//			if (userId <= 0) {
//				return Result.fail("无效的用户ID", 400); // 用户ID无效
//			} else {
//				return Result.fail("用户不存在", 500); // 用户不存在
//			}
//		}
//	}





//	private LoginUser convertToLoginUser(MsbUser msbUser) {
//		LoginUser loginUser = new LoginUser();
//		// 将MsbUser转换成LoginUser
//		loginUser.setId(msbUser.getUserId());
//		loginUser.setUserName(msbUser.getUserName());
//		loginUser.setUserEmail(msbUser.getUserEmail());
//		loginUser.setUserRole(msbUser.getUserRole());
//		loginUser.setUserBio(msbUser.getUserBio());
//		loginUser.setUserPhone(msbUser.getUserPhone());
//		// 其他属性的映射
//		// 如果需要，可以添加更多的映射逻辑
//		return loginUser;
//	}


	@PostMapping("/login")
	public Result<LoginUser> login(@RequestParam String usernameOrEmail, @RequestParam String password) {
		LoginUser loginUser = userService.login(usernameOrEmail, password);
		if (loginUser == null) {
			return Result.fail("用户不存在", 404);
		}
		return Result.success(loginUser);
	}

		@GetMapping("/getUserByEmail/{email}")
		public Result<LoginUser> getUserByEmail(@PathVariable String email) {
			LoginUser userById = userService.getUserByEmail(email);
			if (userById == null) { return Result.fail("⽤户不存在", 404);
		}
			return Result.success(userById);
			}


	@PostMapping("/register")
	public ResponseEntity<Result<MsbUser>> registerUser(@RequestBody MsbUser user) {
		if (user != null) {
			try {
				// 调用服务层的 register 方法进行用户注册
				userService.register(user);

				// 注册成功，返回成功响应
				return ResponseEntity.ok(Result.success(user));
			} catch (IllegalStateException e) {
				// 注册失败，返回错误响应
				return ResponseEntity.badRequest().body(Result.fail("注册失败",404));
			} catch (Exception e) {
				// 服务器内部错误，返回错误响应
				return ResponseEntity.status(500).body(Result.fail("An error occurred during registration.", 500));
			}
		} else {
			// 请求体为空，返回错误响应
			return ResponseEntity.badRequest().body(Result.fail("Invalid user data.", 400));
		}
	}







	}



