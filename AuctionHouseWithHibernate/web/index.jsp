<%@page import="javax.swing.text.Document"%>
<%@page import="cse305.project3.servlets.InitServlet"%>
<%@page import="cse305.project3.servlets.Storage"%>
<%@page import="cse305.project3.auction_objects.*"%>
<%@page import="cse305.project3.session_factory.SessionFactoryStore"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getParameter("Type") != null && request.getParameter("Price") != null) {
        Storage.getStorage().setItemTypeSelected(request.getParameter("Type"));
    }
%>
<!DOCTYPE html> 
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.easing.min.js"></script>
        <script type="text/javascript" src="js/jquery.lavalamp.min.js"></script>
        <script type="text/javascript" src="js/HomeBrewedJava2.js"></script>
        <script type="text/javascript">
            document.onreadystatechange = function () 
            {  
                if (document.readyState == "complete") 
                {  
                    $("#lava_menu").lavaLamp({
                        fx: "backout",
                        speed: 700
                    });
                }
            }
        </script>

        <title>Bazbids</title>
    </head>

    <body>
        <div id="invisable" class="invisable" onclick="loginDisplay(0)"></div>
        <div class="super_main">
            <div id="invisable" class="invisable" onclick="loginDisplay(0)"></div>
            <div class="logo"></div>
            <div class="login">
                <div class="login-home">
                    <INPUT type="button" onclick="loginDisplay(1)" class="login-button" VALUE="Sign In"/>
                </div>
                <div class="loginPOP" id="loginPOP">
                    <div class="logonPOPmove">
                        <form action="login.php" method="post" accept-charset="UTF-8">					
                            <input type="hidden" name="submitted" id="submitted" value="1"/>					
                            <label for="username" >Username:</label>			
                            <input class="login2" style="top:-8px" type="text" name="username" id="username"  maxlength="50" />					
                            <br/><br/>					
                            <label for="password" >Password: </label>					
                            <input class="login2" style="top:33px" type="password" name="password" id="password" maxlength="50" />					
                            <br/><br/>					
                            <input class="submit" type="submit" name="Submit" value="Sign In" />				
                        </form>
                    </div>
                </div>
                <div class="welcomeTextDiv">
                    <p class="welcomeText" >welcome, <a class="blue_links" href="member.php">Sally Green</a></p>
                </div>
            </div>
            <div class="menu">

                <div id="menu_container">  
                    <div id="menubar">
                        <ul class="lavaLampWithImage" id="lava_menu" >
                            <li class="current"><a href="Home.php">&#160;&#160;Auctions</a></li>
                            <li><a href="member.php">&#160;&#160;Settings</a></li>
                            <li><a href="upload.php">&#160;&#160;Help</a></li>
                            <li><a href="upload.php">&#160;&#160;About us</a></li>
                        </ul>
                    </div>
                </div>

                <div class="searchBar_menu">
                    <div class="guidevue-gallery"> 
                        <div> 
                            <form action="index.jsp">
                                <input id="searchbox" onblur="backToOriginal('searchbox')" type="text" class="searchbox" name="ItemName" onmousedown="textArea('searchbox')" value="Find an item" /> 
                                <input type="image" src="images/mag2.png" alt="search" height="23" width="23" class="searchbox_submit" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="sorting-block">
                <h2 class="narrow-results">Narrow Results</h2>
                <br/>
                <form action="index.jsp" id="narrowDown" method="get" accept-charset="UTF-8">
                    <select class="drop-list" name="Type">						
                        <option value=<%=Storage.getStorage().getItemTypeSelected()%> selected>Product Type</option>					
                        <option value="Car">Car</option>	
                        <option value="Boat">Boat</option>
                        <option value="Computer">Computer</option>
                        <option value="DVD">DVD</option>	
                        <option value="Game">Game</option>
                        <option value="Furniture">Furniture</option>	
                        <option value="MP3 Player">MP3 Player</option>
                        <option value="MP4 Player">MP4 Player</option>		
                    </select>
                    <br/><br/>
                    <p>Current Bid</p>
                    <select class="drop-list" name="Price">						
                        <option value=" " selected>Price Range</option>					
                        <option value="0-10">$0-$9.99</option>						
                        <option value="10-30">$10-$29.99</option>
                        <option value="30-50">$30-$49.99</option>
                        <option value="50-100">$50-$99.99</option>	
                        <option value="100-200">$100-$199.99</option>
                        <option value="200-500">$200-$499.99</option>		
                        <option value="500-1000">$500-$999.99</option>
                        <option value="1000">$1000 and up</option>	
                    </select>
                    <br/><br/>
                    <input class="sort-button" type="submit" value="Search"/>
                </form>
            </div>
            <div class="sorting-block-top">
                <p class="sort-by-text">Sort by:</p>
                <div class="sort-top-mini-block">
                    <form action="index.jsp" method="post" accept-charset="UTF-8">
                        <select class="drop-list2">						
                            <option value="AZ" selected>Name: A-Z</option>					
                            <option value="ZA">Name: Z-A</option>						
                            <option value="CH">Current Bid: Highest</option>
                            <option value="CL">Current Bid: Lowest</option>
                            <option value="MH">Minimum Bid: Highest</option>
                            <option value="ML">Minimum Bid: Lowest</option>
                            <option value="ES">Time: Ending Soonest</option>	
                            <option value="NL">Time: Newly Listed</option>
                        </select>
                        <input class="sort-button" type="submit" name="Submit" value="Sort" />
                    </form>
                </div>
            </div>
            <div class="mainBody">

                <%
                    response.setHeader("Cache-Control", "no-cache");
                    response.setHeader("Pragma", "no-cache");
                    response.setDateHeader("Expires", 0);
                    //InitServlet initServlet = new InitServlet();
                    //initServlet.processRequest(request, response);            //uncomment to initialize db
                    //response.setIntHeader("refresh", 1);
                    SessionFactory sessionFactory =
                            SessionFactoryStore.getSessionFactoryStore().getSessionFactory();

                    Session session1 = sessionFactory.openSession();
                    session1.beginTransaction();

                    //if user searched for auction item
                    if (request.getParameter("ItemName") != null) {
                        String itemSearch = request.getParameter("ItemName");
                        Query queryAuction = session1.createQuery("from Auction where item.name like \'%" + itemSearch + "%\'");
                        List listOfAuctions = queryAuction.list();
                        Iterator auctionIterator = listOfAuctions.iterator();
                        printAuctions(auctionIterator, out);

                        //if user browsing auctions by type or price
                    } else if (request.getParameter("Type") != null && request.getParameter("Price") != null) {
                        Storage.getStorage().setItemTypeSelected(request.getParameter("Type"));
                        response.setIntHeader("refresh", 0);
                        response.setIntHeader("refresh", 60);
                        System.out.println("Type: " + request.getParameter("Type") + "Price: "
                                + "Price" + request.getParameter("Price"));
                        //if both are "+"
                        if (request.getParameter("Price").equals(" ") && request.getParameter("Type").equals(" ")) {
                            Query queryAuctions = session1.createQuery("from Auction");
                            List listOfAuctions = queryAuctions.list();
                            Iterator auctionIterator = listOfAuctions.iterator();
                            printAuctions(auctionIterator, out);
                        } //if only Type
                        else if (request.getParameter("Price").equals(" ")) {
                            System.out.println("I am here");
                            String type = request.getParameter("Type");
                            Query queryAuction = session1.createQuery("from Auction where item.type=:itemType");
                            queryAuction.setParameter("itemType", type);
                            List listOfAuctions = queryAuction.list();
                            Iterator auctionIterator = listOfAuctions.iterator();
                            printAuctions(auctionIterator, out);
                        } //if only price
                        else if (request.getParameter("Type").equals(" ")) {
                            String price = request.getParameter("Price");
                            if (price.equals("1000")) {
                                Query queryAuction = session1.createQuery("from Auction where currentBid>=:lowRange");
                                queryAuction.setParameter("lowRange", Float.parseFloat(price));
                                List listOfAuctions = queryAuction.list();
                                Iterator auctionIterator = listOfAuctions.iterator();
                                printAuctions(auctionIterator, out);
                            } else {
                                String range[] = price.split("-");
                                Query queryAuction = session1.createQuery("from Auction where currentBid>=:lowRange and "
                                        + "currentBid <:highRange");
                                queryAuction.setParameter("lowRange", Float.parseFloat(range[0]));
                                queryAuction.setParameter("highRange", Float.parseFloat(range[1]));
                                List listOfAuctions = queryAuction.list();
                                Iterator auctionIterator = listOfAuctions.iterator();
                                printAuctions(auctionIterator, out);
                            }
                        } else {
                            //if both
                            String type = request.getParameter("Type");
                            String price = request.getParameter("Price");
                            if (price.equals("1000")) {
                                Query queryAuction = session1.createQuery("from Auction where item.type =:itemType and "
                                        + "currentBid>=:lowRange");
                                queryAuction.setParameter("itemType", type);
                                queryAuction.setParameter("lowRange", Float.parseFloat(price));
                                List listOfAuctions = queryAuction.list();
                                Iterator auctionIterator = listOfAuctions.iterator();
                                printAuctions(auctionIterator, out);
                            } else {
                                String range[] = price.split("-");
                                Query queryAuction = session1.createQuery("from Auction where item.type=:itemType and "
                                        + "currentBid>=:lowRange and currentBid <:highRange");
                                queryAuction.setParameter("itemType", type);
                                queryAuction.setParameter("lowRange", Float.parseFloat(range[0]));
                                queryAuction.setParameter("highRange", Float.parseFloat(range[1]));
                                List listOfAuctions = queryAuction.list();
                                Iterator auctionIterator = listOfAuctions.iterator();
                                printAuctions(auctionIterator, out);

                            }
                        }
                        //show all auctions
                    } else {
                        Query queryAuctions = session1.createQuery("from Auction");
                        List listOfAuctions = queryAuctions.list();
                        Iterator auctionIterator = listOfAuctions.iterator();
                        printAuctions(auctionIterator, out);
                    }
                    session1.getTransaction().commit();
                    session1.close();
                %>

                <%!
                    public void printAuctions(Iterator auctionIterator, javax.servlet.jsp.JspWriter out)
                            throws java.io.IOException {
                        boolean color = false;
                        while (auctionIterator.hasNext()) {
                            Auction auction = (Auction) auctionIterator.next();
                            out.println(auction.getItem().getName());
                            if (color) {
                                out.println("<div class=\"big-block\" style=\"background-color:#e0e1ec;\">");
                            } else {
                                out.println("<div class=\"big-block\">");
                            }
                            color = !color;
                            out.println("<div class=\"little-block1\">");
                            out.println("<p><a class=\"blue_links\">" + auction.getItem().getName() + "</a></p>");
                            out.println("<p>Seller: " + auction.getSeller().getFirstName() + "</p>");
                            out.println("</div>");
                            out.println("<div class=\"little-block2\">");
                            out.println("<p>Start Date: " + auction.getOpeningDate() + "</p>");
                            Timestamp timeLeft = new Timestamp(
                                    auction.getClosingDate().getTime() - new Date().getTime());
                            int daysLeft = (int) (timeLeft.getTime() / (1000 * 60 * 60 * 24));
                            int hoursLeft = (int) (((timeLeft.getTime() - (1000 * 60 * 60 * 24 * daysLeft)) / (1000 * 60 * 60)));
                            int minutesLeft = (int) (((timeLeft.getTime() - (1000 * 60 * 60 * 24 * daysLeft)
                                    - (1000 * 60 * 60 * hoursLeft)) / (1000 * 60)));
                            out.println("<p>Time left to bid: " + daysLeft + " days " + hoursLeft + " hours and " + minutesLeft + " minutes</p>");
                            out.println("</div>");
                            out.println("<div class=\"little-block3\">");
                            out.println("<p>Minimum bid: " + auction.getMinBid() + "</p>");
                            out.println("<p>Bid Increment: " + auction.getIncrement() + "</p>");
                            out.println("</div>");
                            out.println("<div class=\"little-block4\">");
                            out.println("<p>Current bid: " + auction.getCurrentBid() + "</p>");
                            //session1.createQuery(from Bid where auction.getAuctionID() =:desiredAuctionID);

                            out.println("<p>Placed <span class=\"red-time\">TO DO</span> minutes ago</p>");
                            out.println("</div>");

                            out.println("</div>");
                        }
                        out.close();
                    }
                %>

            </div>

        </div>
    </body>