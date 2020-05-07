package com.rb.login.filter;

import com.rb.login.exception.BusinessException;
import com.rb.login.model.R;
import com.rb.login.util.JSONUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 统一异常处理
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void bindExceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        e.printStackTrace();
        R error = new R(e.getMessage());
        if (e instanceof BusinessException) {
            response.setStatus(500);
        }
        returnResponse(response, error);
    }

//    /**
//     * 处理所有接口参数验证异常
//     *
//     * @param
//     * @return
//     */
//    public void bindMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex, HttpServletResponse response, R error) {
//        BindingResult bindingResult = ex.getBindingResult();
//        String errorMessage = "";
//        if (bindingResult.hasErrors()) {
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            if (errors.size() > 0) {
//                StringBuilder msgBuilder = new StringBuilder();
//                for (ObjectError objectError : errors) {
//                    msgBuilder.append(objectError.getDefaultMessage()).append(",");
//                }
//                //remove the end of ,
//                errorMessage = msgBuilder.toString();
//                if (errorMessage.length() > 1) {
//                    errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
//                }
//            }
//        }
//        error = new R(MyStringUtil.isEmpty(errorMessage) ? ex.getMessage() : errorMessage);
//        response.setStatus(400);
//        returnResponse(response, error);
//    }
//
//    /**
//     * 用来处理参数验证异常
//     *
//     * @param ex
//     * @return
//     */
//    public void bindConstraintViolationExceptionHandler(ConstraintViolationException ex, HttpServletResponse response, R error) {
//        String errorMessage = "";
//        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
//        if (constraintViolations.size() > 0) {
//            StringBuilder msgBuilder = new StringBuilder();
//            for (ConstraintViolation constraintViolation : constraintViolations) {
//                msgBuilder.append(constraintViolation.getMessage()).append(",");
//            }
//            //remove the end of ,
//             errorMessage = msgBuilder.toString();
//            if (errorMessage.length() > 1) {
//                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
//            }
//        }
//        error = new R(MyStringUtil.isEmpty(errorMessage) ? ex.getMessage() : errorMessage);
//        response.setStatus(400);
//        returnResponse(response, error);
//    }

    public void returnResponse(HttpServletResponse response, R error){
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JSONUtil.toJSON(error));
            response.getWriter().close();
            return;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
