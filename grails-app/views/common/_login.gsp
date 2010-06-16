
<%@ page import="org.pih.warehouse.Warehouse" %>
<g:form controller="auth" action="doLogin" method="post">		  
    <div class="dialog">
		<g:if test="${flash.message}">
		    <div class="message">${flash.message}</div>
		</g:if>		
		<g:hasErrors bean="${userInstance}">
           <div class="errors">
               <g:renderErrors bean="${userInstance}" as="list" />
           </div>
        </g:hasErrors>		
	<div class="notice">
		Login as <b>manager</b> : <b>password</b> to use the system as a <b>Warehouse Manager</b>. 
	</div>			
		<fieldset> 			
			<div id="loginFormFields" style="padding:25px;">
				<div>
				    <label for="password">Log into:</label><br/>
				    <g:select class="large" name="warehouse.id" from="${org.pih.warehouse.Warehouse.list()}" 
				    	optionKey="id" value=""
				    	noSelection="[null: 'Choose warehouse to manage']"/>
				</div>  	    
				<div>
					<br/>
					<hr/>
					<br/>
					<div>
						<label for="username">Username or email:</label><br/>
						<input type="text" class="title" name="username" id="username" value="${userInstance?.username}">
					</div> 
					<div>
						<label for="password">Password:</label><br/>
						<input type="password" class="title" name="password" id="password" value="${userInstance?.password}">
					</div>
				
				</div>
			</div>
		</fieldset> 
	</div>
    <div class="buttons">
		<span class="button">
			<g:submitButton name="login" class="save" value="${message(code: 'default.button.login.label', default: 'Login')}" />
		</span>	
    </div>	
	<br/>


</g:form>