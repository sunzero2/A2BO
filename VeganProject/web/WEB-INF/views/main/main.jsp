<%@page import="com.a2bo.main.model.vo.MainVlv"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%
   List vgList = (List)request.getAttribute("vgList");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Easy Veggy's Healthy Choice</title>
<link rel="icon" type="image/x-icon" href="/vgan/resources/image/after/faviconv.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/vgan/resources/css/styles.css" rel="stylesheet" />
<!-- <style>
.topBanner {
	margin-top: 0px;
}
</style> -->
</head>
    <body id="page-top">
	<%@ include file="../top/top.jsp" %>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">Start Your Happy</div>
                <div class="masthead-heading text-uppercase">EASY VEGGY</div>
                <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">LET's START</a>
            </div>
        </header>
        <!-- 카드선택하기 디브!!! -->
        <section class="page-section" id="services">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">at Your choice!</h2>
                    <h3 class="section-subheading text-muted">PICK ANY "THREE" CARDS YOU LIKE</h3>
                </div>
                <!-- 카드넣는 디브 -->
                <div class="row text-center">
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-pageline fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="8" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">GRAIN/곡식</h4>
                        <p class="text-muted">쌀,보리,밀,옥수수,귀리,기장,오트밀,검은콩,통밀,메밀,호밀,참깨,대두,녹두,렌틸,기장,수수,조,율무...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-drumstick-bite fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="1" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">MEAT/육류</h4>
                        <p class="text-muted">소, 돼지,양,염소,토끼...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-carrot fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="8" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">VEGETABLE/채소</h4>
                        <p class="text-muted">토마토,양배추,케일,샐러리,아스파라거스,가지,고추,오이,시금치,호박,고구마,감자,당근,바질,비트...</p>
                    </div>
                     <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-fish fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="3" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">FISH/어류</h4>
                        <p class="text-muted">갈치,고등어,광어,연어,참치,도미,민어,멸치,장어,송어...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-certificate fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="6" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Fungus/균류</h4>
                        <p class="text-muted">느타리,팽이,새송이,양송이,표고,목이,석이,송로,트러플,상황,말굽...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-kiwi-bird fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="2" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Poultry/가금류</h4>
                        <p class="text-muted">닭,오리,칠면조,etc...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-bacon fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="7" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Seaweed/해조류</h4>
                        <p class="text-muted">다시마,톳,모자반,미역,청각,파래,매생이,김,우뭇가사리...</p>
                    </div>
                     <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-lemon fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="9" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Fruits/열매류</h4>
                        <p class="text-muted">바나나,사과,복숭아,포도,딸기,자두,망고,무화과,귤,대추,레몬,라임,멜론,블루베리,아보카도,앵두,올리브,유자,자몽,파인애플...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-anchor fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="3" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Crustacean/갑각류</h4>
                        <p class="text-muted">꽃게,새우,바다가재,가재,게,왕게,대게...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-egg fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="4" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">EGGS/난류</h4>
                        <p class="text-muted">계란,성게알,청어알,연어알,숭어알,민어알,날치알,캐비어,명란...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-tint fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="5" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Oil/유지류</h4>
                        <p class="text-muted">마요네즈,땅콩버터,마가린,버터,식물성유,동물성유,올리브유...</p>
                    </div>
                     <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-cloud-meatball fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="3" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Muscles/조개류</h4>
                        <p class="text-muted">가리비,굴,모시조개,소라,전복,홍합,대합,바지락,소라,우렁,전복...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-cheese fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="5" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Dairy/유제품</h4>
                        <p class="text-muted">휘핑,크림,치즈,우유,요구르트,플레인,연유,아이스크림...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-stumbleupon fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="3" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Mollusks/연체류</h4>
                        <p class="text-muted">낙지,문어,오징어,주꾸미,꼴뚜기,해삼,해파리...</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-cookie-bite fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="8" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Bakery/베이커리</h4>
                        <p class="text-muted">비건을 위한 베이커리</p>
                    </div>
                    <div class="col-md-3">
                        <span class="fa-stack fa-4x"><i class="fas fa-circle fa-stack-2x text-primary"></i><i class="fas fa-mug-hot fa-stack-1x fa-inverse"></i></span>
                        <br>
                        <input type="checkbox" class="menuRadio" value="9" name="ing"
							onclick="count_ck(this)">
                        <h4 class="my-3">Beverage/음료 </h4>
                        <p class="text-muted">커피,차,건강주스,착즙주스,소다...</p>
                    </div>
                    
                </div>
                <div class="leval">
					<button onclick="ckclear();">선택초기화</button>
					<button onclick="radiock();">선택완료</button>
				</div>
			     
            </div>
            
        </section>
        <!-- MENU CARD/메뉴카드 나타나 Grid-->
        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                <div id="myLevel" class="text-center">
                   
                </div>
				<div class="row">
                    <div class="col-lg-4 col-sm-6 mb-4" id="col-lg-4">
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal2"
                                ><div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-seedling fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="/vgan/resources/image/after/portfolio/salad.jpg" alt=""
                            /></a>
                            <div class="portfolio-caption">
                                <div id="menuName0" class="portfolio-caption-heading"></div>
                                <div id="restName0" class="portfolio-caption-subheading text-muted"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4" id="col-lg-4" >
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal2"
                                ><div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-seedling fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="/vgan/resources/image/after/portfolio/salad.jpg" alt=""
                            /></a>
                            <div class="portfolio-caption">
                                <div id="menuName1" class="portfolio-caption-heading"></div>
                                <div id="restName1" class="portfolio-caption-subheading text-muted"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4" id="col-lg-4">
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal2"
                                ><div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-seedling fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="/vgan/resources/image/after/portfolio/salad.jpg" alt=""
                            /></a>
                            <div class="portfolio-caption">
                                <div id="menuName2" class="portfolio-caption-heading"></div>
                                <div id="restName2" class="portfolio-caption-subheading text-muted"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4" id="col-lg-4">
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal2"
                                ><div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-seedling fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="/vgan/resources/image/after/portfolio/salad.jpg" alt=""
                            /></a>
                            <div class="portfolio-caption">
                                <div id="menuName3" class="portfolio-caption-heading"></div>
                                <div id="restName3" class="portfolio-caption-subheading text-muted"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4" id="col-lg-4">
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal2"
                                ><div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-seedling fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="/vgan/resources/image/after/portfolio/salad.jpg" alt=""
                            /></a>
                            <div class="portfolio-caption">
                                <div id="menuName4" class="portfolio-caption-heading"></div>
                                <div id="restName4" class="portfolio-caption-subheading text-muted"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4" id="col-lg-4">
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal2"
                                ><div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-seedling fa-3x"></i></div>
                                </div>
                               <img class="img-fluid" src="/vgan/resources/image/after/portfolio/salad.jpg" alt=""
                            /></a>
                            <div class="portfolio-caption">
                                <div id="menuName5" class="portfolio-caption-heading"></div>
                                <div id="restName5" class="portfolio-caption-subheading text-muted"></div>
                            </div>
                        </div>
                    </div>
            </div>
         </div>
            <!-- <form class="bbb" action="/vgan/menuinfo">
				<input name='menuName' type='hidden'>
				<input name='menuId' type='hidden'>
				<input name='menuPri' type='hidden'>
				<input name='restName' type='hidden'>
				<input name='menuLocation' type='hidden'>
				<input name='restPhone'type='hidden'>
				<input name='restHour' type='hidden'>



			</form> -->
        </section>
        <!-- Footer-->
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-left">Copyright © Easy Veggy 2020</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-twitter"></i></a><a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a><a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <div class="col-lg-4 text-lg-right"><a class="mr-3" href="#!">Privacy Policy</a><a href="#!">Terms of Use</a></div>
                </div>
            </div>
        </footer>
        <!-- Portfolio Modals--><!-- Modal 1-->
        <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="close-modal" data-dismiss="modal"><img src="/vgan/resources/image/after/close-icon.svg" /></div>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-8">
                                <div class="modal-body">
                                    <!-- Project Details Go Here-->
                                    <h2 class="text-uppercase">Project Name</h2>
                                    <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                    <img class="img-fluid d-block mx-auto" src="/vgan/resources/image/after/portfolio/01-full.jpg" alt="" />
                                    <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                                    <ul class="list-inline">
                                        <li>Date: January 2020</li>
                                        <li>Client: Threads</li>
                                        <li>Category: Illustration</li>
                                    </ul>
                                    <button class="btn btn-primary" data-dismiss="modal" type="button"><i class="fas fa-times mr-1"></i>Close Project</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal 2-->
        <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="close-modal" data-dismiss="modal"><img src="/vgan/resources/image/after/close-icon.svg" /></div>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-8">
                                <div class="modal-body">
                                    <!-- Project Details Go Here-->
                                    <h2 class="text-uppercase">Project Name</h2>
                                    <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                    <img class="img-fluid d-block mx-auto" src="/vgan/resources/image/after/portfolio/02-full.jpg" alt="" />
                                    <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                                    <ul class="list-inline">
                                        <li>Date: January 2020</li>
                                        <li>Client: Explore</li>
                                        <li>Category: Graphic Design</li>
                                    </ul>
                                    <button class="btn btn-primary" data-dismiss="modal" type="button"><i class="fas fa-times mr-1"></i>Close Project</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal 3-->
        <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="close-modal" data-dismiss="modal"><img src="/vgan/resources/image/after/close-icon.svg" /></div>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-8">
                                <div class="modal-body">
                                    <!-- Project Details Go Here-->
                                    <h2 class="text-uppercase">Project Name</h2>
                                    <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                    <img class="img-fluid d-block mx-auto" src="/vgan/resources/image/after/portfolio/03-full.jpg" alt="" />
                                    <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                                    <ul class="list-inline">
                                        <li>Date: January 2020</li>
                                        <li>Client: Finish</li>
                                        <li>Category: Identity</li>
                                    </ul>
                                    <button class="btn btn-primary" data-dismiss="modal" type="button"><i class="fas fa-times mr-1"></i>Close Project</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal 4-->
        <div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="close-modal" data-dismiss="modal"><img src="/vgan/resources/image/after/close-icon.svg" /></div>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-8">
                                <div class="modal-body">
                                    <!-- Project Details Go Here-->
                                    <h2 class="text-uppercase">Project Name</h2>
                                    <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                    <img class="img-fluid d-block mx-auto" src="/vgan/resources/image/after/portfolio/04-full.jpg" alt="" />
                                    <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                                    <ul class="list-inline">
                                        <li>Date: January 2020</li>
                                        <li>Client: Lines</li>
                                        <li>Category: Branding</li>
                                    </ul>
                                    <button class="btn btn-primary" data-dismiss="modal" type="button"><i class="fas fa-times mr-1"></i>Close Project</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal 5-->
        <div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="close-modal" data-dismiss="modal"><img src="/vgan/resources/image/after/close-icon.svg" /></div>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-8">
                                <div class="modal-body">
                                    <!-- Project Details Go Here-->
                                    <h2 class="text-uppercase">Project Name</h2>
                                    <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                    <img class="img-fluid d-block mx-auto" src="/vgan/resources/image/after/portfolio/05-full.jpg" alt="" />
                                    <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                                    <ul class="list-inline">
                                        <li>Date: January 2020</li>
                                        <li>Client: Southwest</li>
                                        <li>Category: Website Design</li>
                                    </ul>
                                    <button class="btn btn-primary" data-dismiss="modal" type="button"><i class="fas fa-times mr-1"></i>Close Project</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal 6-->
        <div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="close-modal" data-dismiss="modal"><img src="/vgan/resources/image/after/close-icon.svg" /></div>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-8">
                                <div class="modal-body">
                                    <!-- Project Details Go Here-->
                                    <h2 class="text-uppercase">Project Name</h2>
                                    <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                    <img class="img-fluid d-block mx-auto" src="/vgan/resources/image/after/portfolio/06-full.jpg" alt="" />
                                    <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                                    <ul class="list-inline">
                                        <li>Date: January 2020</li>
                                        <li>Client: Window</li>
                                        <li>Category: Photography</li>
                                    </ul>
                                    <button class="btn btn-primary" data-dismiss="modal" type="button"><i class="fas fa-times mr-1"></i>Close Project</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="/vgan/resources/js/main.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="/vgan/resources/js/jqBootstrapValidation.js"></script>
        <script src="/vgan/resources/js/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="/vgan/resources/js/scripts.js"></script>
        <!-- topBanner JS -->
        <script src="/vgan/resources/js/top.js"></script>
        </body>
</html>