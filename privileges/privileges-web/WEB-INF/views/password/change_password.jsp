<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="win" id="openbox">
    <h3 class="titleA">修改密码</h3>
    <div class="box">
        <table>
           <tr>
               <th valign="top" width="25%">请输入原密码：</th>
               <td>
                   <input type="password" id="pwd" name="pwd"/>
                   <em id="pwdEm"><img src="<%=basePath%>skin/default/images/common/public/right.png"></em>
                   <p id="pwdErrPanel">代理商第一次登录，请改密码</p>
               </td>
           </tr>
           <tr>
               <th valign="top">请输入新密码：</th>
               <td>
                   <div class="new-password">
                   		<input type="password" id="pwd_first" name="pwd_first"/>
                        <div>
                             <em><img src="<%=basePath%>skin/default/images/common/public/triangle01.png"></em>
                             <p>新密码至少由8个字符组成，且都是半角字符。</p>
                             <p>至少包含以下字符中的几类：</p>
                             <p><span>●</span>英文大写字母</p>
                             <p><span>●</span>英文小写字母</p>
                             <p><span>●</span>数字</p>
                             <p><span>●</span>特殊符号</p>
                        </div>
                   </div>
                   <em id="pwdFirstEm"><img src="<%=basePath%>skin/default/images/common/public/right.png"></em>
               </td>
           </tr>
           <tr>
               <th valign="top">请确认新密码：</th>
               <td>
                   <input type="password" id="pwd_second" name="pwd_second"/>
                   <em id="pwdSecondEm"><img src="<%=basePath%>skin/default/images/common/public/right.png"></em>
                   <p id="newPwdInfoPanel"></p>
               </td>
           </tr>
        </table>
    </div>
    <div class="btn">
        <a href="javascript:void(0)" onclick="changePwd()">确认</a>
        <a href="javascript:void(0)" class="cancel">取消</a>
    </div>
</div>
