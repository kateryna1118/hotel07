<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ru" lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8" />
    <title>Ripario Hotel Group</title>
    <meta name="description" content="Ripario Hotel" />
    <meta name="keywords" content="hotel, ripario, egipet" />
    
    <!-- STYLES -->
    <link rel="stylesheet" href="css/style_1.css" type="text/css" media="all" />
    <link type="text/css" href="css/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
    
    <!-- LIBS -->
    <script src="css/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="css/jquery-ui-1.8.22.custom.min.js"></script>
    
    <!-- SCRIPTS -->
    <script src="css/tabs.js" type="text/javascript"></script>
    <script src="css/selectbox.js" type="text/javascript"></script>
</head>
<body>
    <a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a><br/>
    <h1 style="text-align: center; color: #252525; padding: 10px;">Бронирование</h1>
    <div class="tabs">
        <ul class="reset tabs-head">
            <li class="active" id="registration"><a href="#registration" title="����������� ������ �������">Регистрация клиента</a></li>
            <li id="booking"><a href="#booking" title="�������������� ������">Резервирование номера</a></li>
            <li id="incidents"><a href="#incidents" title="���������">Неисправности в номерах</a></li>
            <li id="incidents"><a href="#incidents" title="���������">Менеджер </a></li>
        </ul>
        <div class="clr"></div>
        <div id="tabs">
            <div class="tab" id="registration">
            <form method="post">
                <div class="left-colum">
                    <div style="margin-bottom: 10px;"><strong>Период:</strong></div>
                    <div id="Calendar" style="width: 265px; margin: 0 auto;"></div>
                    <hr style="margin: 25px 0;" />
                    <select class="SelectBox" name="food_type">
                        <option value="0" selected> Тип питания (цена) </option>
                        <option value="1">Только завтрак (20 y.e)</option>
                        <option value="2">Только обед (25 y.e)</option>
                        <option value="3">Только Ужин (20 y.e)</option>
                        <option value="4">Заврак + Обед (45 y.e)</option>
                        <option value="5">Завтрак + Ужин (40 y.e)</option>
                        <option value="6">Обед + Ужин  (45 y.e)</option>
                        <option value="7">Завтрак + Обед + Ужин (65 y.e)</option>
                        <option value="8">Без (0 y.e)</option>
                    </select>
                    <hr style="margin: 25px 0;" />
                    <table>
                        <tr>
                            <td style="font-weight: 700; width: 185px; padding-right: 10px;">Количество взрослых:</td>
                            <td><input type="number" max="5" min="1" name="adults" value="1" /></td>
                        </tr>
                        <tr>
                            <td style="font-weight: 700; width: 185px; padding-right: 10px;">Количество детей:</td>
                            <td><input type="number" max="3" min="0" name="children" value="0" /></td>
                        </tr>
                    </table>
                </div>
                <fieldset>
                    <legend>Свободные номера</legend>
                    <ul class="reset rooms">
                        <li id="room1"><label for="room1"><input type="checkbox" name="room" id="room1" value="1" /> 1й Номер (<strong>Premius Class</strong>)</label></li>
                        <li id="room4"><label for="room4"><input type="checkbox" name="room" id="room4" value="4" /> 4й Номер (<strong>VIP Class</strong>)</label></li>
                        <li id="room14"><label for="room14"><input type="checkbox" name="room" id="room14" value="14" /> 14й Номер (<strong>Standart Class</strong>)</label></li>
                        <li id="room25"><label for="room25"><input type="checkbox" name="room" id="room25" value="25" /> 24й Номер (<strong>President Class</strong>)</label></li>
                        <li id="room31"><label for="room31"><input type="checkbox" name="room" id="room31" value="31" /> 31й Номер(<strong>Standart Class</strong>)</label></li>
                        <li id="room32"><label for="room32"><input type="checkbox" name="room" id="room32" value="32" /> 32й Номер (<strong>Newlyweds Class</strong>)</label></li>
                    </ul>
                    <hr style="margin: 25px 0;" />
                    <div id="rooms"></div>
                </fieldset>
                <fieldset class="width">
                    <legend>Данные по клиенту</legend>
                    <table>
                        <tr>
                            <td style="font-weight: 700; width: 200px; padding-right: 10px;">Имя:</td>
                            <td><input type="text" id="ClientName" name="ClientName" /></td>
                        </tr>
                        <tr>
                            <td style="font-weight: 700; width: 200px; padding-right: 10px;">Фамилия:</td>
                            <td><input type="text" id="ClientLastName" name="ClientLastName" /></td>
                        </tr>
                        <tr>
                            <td style="font-weight: 700; width: 200px; padding-right: 10px;">Дата рождения:</td>
                            <td><input type="text" id="ClientBirthDay" name="ClientBirthDay" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="padding: 10px;"></td>
                        </tr>
                        <tr>
                            <td style="font-weight: 700; width: 200px; padding-right: 10px;">Номер паспорта:</td>
                            <td><input type="text" id="ClientPassportNumber" name="ClientPassportNumber" /></td>
                        </tr>
                        <tr>
                            <td style="font-weight: 700; width: 200px; padding-right: 10px;">Когда выдан:</td>
                            <td><input type="text" id="ClientPassportDate" name="ClientPassportDate" /></td>
                        </tr>
                        <tr>
                            <td style="font-weight: 700; width: 200px; padding-right: 10px;">Кем выдан:</td>
                            <td><input type="text" id="ClientPassportWho" name="ClientPassportWho" /></td>
                        </tr>
                    </table>
                </fieldset>
                <div class="clr"></div>
                <div style="text-align: left;"><input type="submit" value="Заселить клиента" /></div>
            </form>
            </div>
            <div class="tab" id="booking">ВКЛАДКА 2::Резервирование номера</div>
            <div class="tab" id="incidents">ВКЛАДКА 3::Поломки</div>
        </div>
    </div>
</body>
</html>