<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ tag body-content="empty"%>
<%@ attribute name="totalPageCount" type="java.lang.Integer"
	required="true"%>
<%@ attribute name="nowPage" type="java.lang.Integer" required="true"%>
<!-- 전체 페이지 수와 현재 페이지 수를 받아서 페이지 이동 목록을 구현  -->
<%
	int totalPageBlock = (int) (Math.ceil(totalPageCount / 10.0)); // 페이지의 갯수가 55개 일때 55 / 10 즉 5가 나온다
	System.out.println("paging->totalPageBlock(페이징 블록 개수): " + totalPageBlock); 
	int nowPageBlock = (int) Math.ceil(nowPage / 10.0);
	System.out.println("paging->nowPageBlock(현재 페이징 블록 번호): " + nowPageBlock); //
	int startPage = (nowPageBlock - 1) * 10 + 1;
	System.out.println("paging->startPage(현재 블록의 출발 페이지 번호): " + startPage);
	int endPage = 0;
	String contextPath = application.getContextPath();

	if (contextPath == null || contextPath.trim().equals("")) {
		contextPath = "";
	} else {
		//contextPath = "/"+contextPath;
	}
	if (totalPageCount > nowPageBlock * 10) {
		endPage = nowPageBlock * 10;
	} else {
		endPage = totalPageCount;
	}

	out.println("<nav aria-label=\"Page navigation\">");
	out.println("<ul class=\"pagination\">");
	if (nowPageBlock > 1) {
		out.print("<li>");
		out.print(
				"<a href=\"" + contextPath + "/board/list/" + (startPage - 1) + "\" aria-label=\"Previous\">");
		out.print("◀</a>");
		out.println("</li>");
	}
	for (int i = startPage; i <= endPage; i++) {
		out.print(" ");
		if (i == nowPage) {
			out.print("<li class=\"active\">");
		} else {
			out.print("<li>");
		}
		out.print("<a href=\"" + contextPath + "/board/list/" + (i) + "\">");
		out.print(i);
		out.print("</a>");
		out.println("</li>");
	}
	if (nowPageBlock < totalPageBlock) {
		out.print("<li>");
		out.print("<a href=\"" + contextPath + "/board/list/" + (endPage + 1) + "\" aria-label=\"Next\">");
		out.print("▶</a>");
		out.println("</li>");
	}
	out.println("</ul>");
	out.println("</nav>");
%>
