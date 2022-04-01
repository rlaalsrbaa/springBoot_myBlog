<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="메인" />
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
	<div class="container mx-auto p-3 border-2 border-purple-200		">
		<div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-2">


			<div class=" border-2 p-3 m-2 border-purple-100		">
				<p class="text-xl m-2 font-bold">${tipAndTechBoard.name }게시판</p>
				<c:forEach var="article" items="${tipAndTechArticles}">
					<div
						class="bg-green-50	 hover:bg-green-100	flex h-12 items-center p-2 border-2 border-b-0">
						<a
							class="btn-text-link block w-full truncate w-min flex mr-3 text-lg"
							href="${rq.getArticleDetailUriFromArticleList(article)}">
							${article.title} </a>
						<p class="flex">
							<i class="far fa-thumbs-up"></i> ${article.goodReactionPoint}
						</p>
					</div>
				</c:forEach>
				<div class="border-t-2"></div>
			</div>
			
			<div class=" border-2 border-purple-100 p-3 m-2 ">
				<p class="text-xl m-2 font-bold">${freeBoard.name }게시판</p>
				<c:forEach var="article" items="${freeArticles}">
					<div
						class="bg-green-50	 hover:bg-green-100	flex h-12 items-center p-2 border-2 border-b-0">
						<a
							class="btn-text-link block w-full truncate w-min flex mr-3 text-lg"
							href="${rq.getArticleDetailUriFromArticleList(article)}">
							${article.title} </a>
						<p class="flex">
							<i class="far fa-thumbs-up"></i> ${article.goodReactionPoint}
						</p>
					</div>
				</c:forEach>
				<div class="border-t-2"></div>

			</div>
			<div class=" border-2 border-purple-100 p-3 m-2 ">
				<p class="text-xl m-2 font-bold">${noticeBoard.name }게시판</p>
				<c:forEach var="article" items="${noticeArticles}">
					<div
						class="bg-green-50	 hover:bg-green-100	flex h-12 items-center p-2 border-2 border-b-0">
						<a
							class="btn-text-link block w-full truncate w-min flex mr-3 text-lg"
							href="${rq.getArticleDetailUriFromArticleList(article)}">
							${article.title} </a>
						<p class="flex">
							<i class="far fa-thumbs-up"></i> ${article.goodReactionPoint}
						</p>
					</div>
				</c:forEach>
				<div class="border-t-2"></div>
			</div>

		</div>
</section>


<%@ include file="../common/foot.jspf"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" />
