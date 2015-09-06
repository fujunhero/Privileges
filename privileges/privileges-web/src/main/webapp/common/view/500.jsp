<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page isErrorPage="true"%>
<html>
	<head>
		<%@include file="crm_common_inc.jsp"%>
	</head>
	<body class="message_page_body">
		<div class="main-wrap">
			<div class="errorthr_page">
				<div class="error-title">
					<span class="wrong_fwn">页面无法显示哦！</span>
					<span class="tishir_fwn">（该页面无法正常访问，错误代码500！）</span>
				</div>
				<div class="error-body">
					<p>
						请检查输入的网址是否正确，或者联系电信客服：
						<br />
						10000(服务电话）
					</p>
				</div>
			</div>
			<div id="debugMessageForDev" style="display: none;padding-left:100px;">
				  <span style="text-align:center;font-family:微软雅黑;color: #ff5202;">[调试辅助信息]</span>
				  <br></br>
				  <textarea rows="10" cols="100">请求URL：${url}</textarea>
			</div>
		</div>

		<div class="index-footer">
			[电信业务经营许可证 A2.B1.B2-20090001]
		</div>
	</body>
</html>


