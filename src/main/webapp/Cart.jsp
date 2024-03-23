<%@ page isELIgnored = "false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
    </head>

    <body onload="loadTotalMoney()">
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <c:if test="${error!=null }">
                 <div class="alert alert-danger" role="alert">
						 ${error}
				</div>
				</c:if>
				<c:if test="${mess!=null }">
                <div class="alert alert-success" role="alert">
				  	${mess}
				</div>
				</c:if>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">STT</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Món ăn</div>
                                                    </th>
                                                     <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Đơn giá</div>
                                                    </th>
                                                     <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Số lượng</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Thành tiền</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Xóa</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:set var = "o" value = "${sessionScope.cart}"/>
                                             <c:set var = "t" value = "0" />
                                             <c:forEach items="${o.items }" var="i">
                                                <tr>
													<c:set var = "t" value = "${t+1}" />
                                                    <td class="align-middle"><strong>${t}</strong></td>
													<td>${i.food.title }</td>
       												<td><fmt:formatNumber pattern = "##.#" type = "number" value = "${i.food.price}" /></td>
													<td>
														<button><a href ="process?num=-1&id=${i.food.id}" >-</a></button>
														<input type = "text" readonly value = "${i.quantity}" />
														<button><a href ="process?num=1&id=${i.food.id}">+</a></button>
													</td>
       												
       												
													<fmt:parseNumber var = "a" type = "number" value = "${i.food.price}"/>
													<fmt:parseNumber var = "b" type = "number" value = "${i.quantity}"/>
													<td><fmt:formatNumber pattern = "##.#" type = "number" value = "${a*b}"/></td>
													<td>
														<form action = "process" method = "post">
															<input type = "hidden" name = "id" value = "${i.food.id }"/>
															<input type = "submit" value = "Return item"/>
														</form>
													</td>
                                                </tr>                                             
                                               </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                           
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
    
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4" id="contentTotalMoney">
                                       <!--  <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>100 $</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10 $</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold">110 $</h5>
                                        </li> -->
                                    </ul><a href="order" class="btn btn-dark rounded-pill py-2 btn-block text-white">Thanh Toán</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>

</html>
</html>
