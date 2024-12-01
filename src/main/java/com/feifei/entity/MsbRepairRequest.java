//package com.feifei.entity;
//
//    import com.baomidou.mybatisplus.annotation.TableName;
//	import lombok.AllArgsConstructor;
//	import lombok.Builder;
//	import lombok.Data;
//	import lombok.NoArgsConstructor;
//
//    import java.sql.Date;
//	import java.time.LocalDateTime;
//
//    @Data
//	@TableName(value = "msb_repair_request") // 指定数据库表名
//	@Builder // 构造器
//	@AllArgsConstructor // 全参构造函数
//	@NoArgsConstructor // ⽆参构造函数
//	public class MsbRepairRequest {
//	private Integer requestId;
//	private Integer userId;
//	private Integer receptionistId;
//	private String phoneModel;
//	private String phoneIssueDescription;
//	private Integer requestStatus;
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;
//	}
//
