function textCounter(field,cntfield,maxlimit) 
{
	if (field.value.length > maxlimit) // if too long...trim it!
	field.value = field.value.substring(0, maxlimit);
	// otherwise, update 'characters left' counter
	else
	cntfield.value = maxlimit - field.value.length;
}
var pageANDtabChange = 0;
function changeEditPage(num)
{
	if(num==1 && pageANDtabChange == 0)
	{
		document.getElementById('About_Me').style.display='block';
		document.getElementById('My_GuideVues').style.display='none';
		document.getElementById('My_Clubs').style.display='none';
	}
	if(num==2 || pageANDtabChange==1)
	{
		document.getElementById('About_Me').style.display='none';
		document.getElementById('My_GuideVues').style.display='block';
		document.getElementById('My_Clubs').style.display='none';
		pageANDtabChange = 0;
	}
	if(num==3)
	{
		document.getElementById('About_Me').style.display='none';
		document.getElementById('My_GuideVues').style.display='none';
		document.getElementById('My_Clubs').style.display='block';
	}
	if(num==4)
	{
		
		parent.location='edit_me.php';
	}
}
var login = 0;
function loginDisplay(num)
{
	if(num==1 && login==0)
	{
		document.getElementById('loginPOP').style.display='block';
		login=1;
		document.getElementById('invisable').style.display='block';
	}
	
	else
	{
		document.getElementById('loginPOP').style.display='none';
		login=0;
		document.getElementById('invisable').style.removeProperty('display');
	}
}
var changepsw = 0;
function loginDisplayChangePassword(num)
{
	if(num==1 && changepsw==0)
	{
		document.getElementById('changePSW').style.display='block';
		changepsw=1;
		document.getElementById('invisable').style.display='block';
	}
	else
	{
		document.getElementById('changePSW').style.display='none';
		changepsw=0;
		document.getElementById('invisable').style.removeProperty('display');
	}
}
var publish=0;
function publishDisplay(num)
{
	if(num==1 && publish==0)
	{
		document.getElementById('publishGV').style.display='block';
		publish=1;
	}
	else
	{
		document.getElementById('publishGV').style.display='none';
		publish=0;
	}
}
function publishDisplaySuccess(num)
{
	if(num==1)
	{
		document.getElementById('publishGVsuccess').style.display='block';
		document.getElementById('greyOut').style.display='block';
	}
	else
	{
		document.getElementById('publishGVsuccess').style.display='none';
		document.getElementById('greyOut').style.display='none';
	}
}
var yesno=0;
function confirmDisplay(num)
{
	if(num==1 && yesno==0)
	{
		document.getElementById('confirmWindow').style.display='block';
		document.getElementById('greyOut').style.display='block';
		yesno=1;
	}
	else
	{
		document.getElementById('confirmWindow').style.display='none';
		document.getElementById('greyOut').style.display='none';
		yesno=0;
	}
}

function changeMemberTo(num)
{
	if(num==1)
	{
		document.getElementById('mem-my_guideVues').style.display='block';
		document.getElementById('mem-my_favorites').style.display='none';
		document.getElementById('mem-my_clubs').style.display='none';
	}
	else if(num==2)
	{
		document.getElementById('mem-my_guideVues').style.display='none';
		document.getElementById('mem-my_favorites').style.display='block';
		document.getElementById('mem-my_clubs').style.display='none';
		
	}
	else if(num==3)
	{
		document.getElementById('mem-my_guideVues').style.display='none';
		document.getElementById('mem-my_favorites').style.display='none';
		document.getElementById('mem-my_clubs').style.display='block';
	}
}
function changeTo(num)
{
	if(num==1)
	{
		document.getElementById('all').style.color='black';
		document.getElementById('recent').style.color='#609cc6';
		document.getElementById('popular').style.color='#609cc6';
	}
	else if(num==2)
	{
		document.getElementById('all').style.color='#609cc6';
		document.getElementById('recent').style.color='black';
		document.getElementById('popular').style.color='#609cc6';
	}
	else if(num==3)
	{
		document.getElementById('all').style.color='#609cc6';
		document.getElementById('recent').style.color='#609cc6';
		document.getElementById('popular').style.color='black';
	}
}
function category(num)
{		
		for (i=1;i<9;i=i+1)
		{
			document.getElementById('catd'+i).style.removeProperty('display');
		}
		document.getElementById('catd'+num).style.display='block';
}
function dynamicMenu()
{
	if(document.getElementById('row4').innerHTML=='')
		document.getElementById('menu_container').style.top='760px';
	if(document.getElementById('row3').innerHTML=='')
		document.getElementById('menu_container').style.top='520px';
	if(document.getElementById('row2').innerHTML=='')
		document.getElementById('menu_container').style.top='280px';
	if(document.getElementById('row1').innerHTML=='')
		document.getElementById('menu_container').style.top='200px';
}
function greyOut(num)
{
	if(num==1)
	{
		document.getElementById('grey-out').style.display='block';
		document.getElementById('author-pricing').style.display='block';
	}
	
	else if(num==0)
	{
		document.getElementById('grey-out').style.removeProperty('display');
		document.getElementById('author-pricing').style.removeProperty('display');
	}
}
function cIDPOP()
{
		document.getElementById('cID-popup').style.display='none';
		if(document.getElementById('cID').value == 'Company Identification Code')
			document.getElementById('cID').value='';
}
function cIDPOPBack()
{
		if(document.getElementById('cID').value == '')
		{
			document.getElementById('cID').value='Company Identification Code';
			document.getElementById('cID-popup').style.removeProperty('display');
			
		}
}
function textArea(num)
{
	if(num=='First Name' && document.getElementById('FirstName').value == num)
	{
		document.getElementById('FirstName').value='';
	}
	else if(num=='Last Name' && document.getElementById('LastName').value == num)
		document.getElementById('LastName').value='';
	if(num=='searchbox' && document.getElementById('searchbox').value == 'Find an item')
		document.getElementById('searchbox').value='';
	else if(document.getElementById(num).value == num)
		document.getElementById(num).value='';
}
function passwordField(num)
{
		document.getElementById(num).style.display='none';
}
function btoPass(num)
{
		if(num=='pass1' && document.getElementById('inputpass1').value == '')
			document.getElementById(num).style.display='block';
		else if(num=='pass2' && document.getElementById('inputpass2').value == '')
			document.getElementById(num).style.display='block';
}
function backToOriginal(num)
{
	if(num=='First Name' && document.getElementById('FirstName').value == '')
	{
		document.getElementById('FirstName').value='First Name';
	}
	else if(num=='Last Name' && document.getElementById('LastName').value == '')
		document.getElementById('LastName').value='Last Name';
	else if(num=='searchbox' && document.getElementById('searchbox').value == '')
		document.getElementById('searchbox').value='Find an item';
	else if(document.getElementById(num).value == '')
		document.getElementById(num).value= num;
}
var gvDescription = 0;
function showMore()
{
		if(gvDescription == 0)
		{
			document.getElementById('GVPD').style.removeProperty('maxHeight');
			document.getElementById('GVPD').style.removeProperty('height');
			
			document.getElementById('GVPD').style.maxHeight='370px';
			jQuery.noConflict();
				jQuery(document).ready(function(){			
					jQuery('textarea').elastic();
					jQuery('textarea').trigger('update');
			});
			document.getElementById('GVPShowMore').src='images/GVP_showLess.png';
			gvDescription = 1;
		}
		else
		{
			document.getElementById('GVPD').style.removeProperty('maxHeight');
			document.getElementById('GVPD').style.removeProperty('height');
			
			document.getElementById('GVPD').style.maxHeight='150px';
			jQuery.noConflict();
				jQuery(document).ready(function(){			
					jQuery('textarea').elastic();
					jQuery('textarea').trigger('update');
			});
			document.getElementById('GVPShowMore').src='images/GVP_showMore.png';
			gvDescription = 0;
		}
		
}