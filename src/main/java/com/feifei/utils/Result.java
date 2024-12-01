package com.feifei.utils;

import lombok.Data;

 	@Data
	public class Result<T> {
        private Integer code; // 状态码
        private String msg;    // 提示信息
        private T data;    // 返回数据
        private long timestamp; // 请求的时间戳

        public boolean isSuccess() {
            return code != null && code == 200;
        }

        public static <T> Result<T> success(T data) {
            Result<T> result = new Result<>();
            result.setCode(200);
            result.setMsg("Success");
            result.setData(data);
            result.setTimestamp(System.currentTimeMillis());
            return result;
        }

        /**
         * 失败响应的默认⽅法
         *
         * @param msg  失败提示信息
         * @param code 失败状态码
         * @param <T>  返回的数据类型
         * @return 返回Result对象
         */
        public static <T> Result<T> fail(String msg, Integer code) {
            Result<T> result = new Result<>();
            result.setCode(code);
            result.setMsg(msg);
            result.setData(null);
            result.setTimestamp(System.currentTimeMillis());
            return result;
        }


    }