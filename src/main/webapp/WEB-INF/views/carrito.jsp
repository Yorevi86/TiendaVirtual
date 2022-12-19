<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-color: #aaa;
            border-spacing: 0;
            margin: 0px auto;
        }

        .tg td {
            background-color: #fff;
            border-color: #aaa;
            border-style: solid;
            border-width: 1px;
            color: #333;
            font-family: Arial, sans-serif;
            font-size: 14px;
            overflow: hidden;
            padding: 10px 5px;
            word-break: normal;
        }

        .tg th {
            background-color: #f38630;
            border-color: #aaa;
            border-style: solid;
            border-width: 1px;
            color: #fff;
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            overflow: hidden;
            padding: 10px 5px;
            word-break: normal;
        }

        .tg .tg-ul38 {
            position: -webkit-sticky;
            position: sticky;
            text-align: left;
            top: -1px;
            vertical-align: top;
            will-change: transform
        }

        .tg .tg-0lax {
            text-align: left;
            vertical-align: top
        }

        .tg .tg-dg7a {
            background-color: #FCFBE3;
            text-align: left;
            vertical-align: top
        }

        .tg-sort-header::-moz-selection {
            background: 0 0
        }

        .tg-sort-header::selection {
            background: 0 0
        }

        .tg-sort-header {
            cursor: pointer
        }

        .tg-sort-header:after {
            content: '';
            float: right;
            margin-top: 7px;
            border-width: 0 5px 5px;
            border-style: solid;
            border-color: #404040 transparent;
            visibility: hidden
        }

        .tg-sort-header:hover:after {
            visibility: visible
        }

        .tg-sort-asc:after,
        .tg-sort-asc:hover:after,
        .tg-sort-desc:after {
            visibility: visible;
            opacity: .4
        }

        .tg-sort-desc:after {
            border-bottom: none;
            border-width: 5px 5px 0
        }

        @media screen and (max-width: 767px) {
            .tg {
                width: auto !important;
            }

            .tg col {
                width: auto !important;
            }

            .tg-wrap {
                overflow-x: auto;
                -webkit-overflow-scrolling: touch;
                margin: auto 0px;
            }
        }
    </style>
    <title>Awesome tienda</title>
</head>
<body>
    <table id="tg-nwxpv" class="tg">
        <thead>
            <tr>
                <th class="tg-ul38">Producto</th>
                <th class="tg-ul38">Cantidad</th>
                <th class="tg-ul38">Importe</th>
            </tr>
        </thead>
        <tbody>                    
            <%
            String carrito = (String) request.getAttribute("carrito");
            out.println(carrito);
            %>
            <tr>
                <th class="tg-ul38" colspan="2">Importe total del carrito:</th>
                <th class="tg-ul38"><%= request.getAttribute("importeTotal") %> Euros</th>
            </tr>
        </tbody>
    </table>

	<%
	if(request.getAttribute("errores") != null){
        out.println("Corregir los errores en:<br>" + request.getAttribute("errores"));
    }
	
	if (request.getSession().getAttribute("address") == null){
		
		out.println("<p>Aún no se ha identificado, identifíquese para realizar la compra.</p>");
		out.println("<button type=\"button\" onclick=\"location.href='login'\">Iniciar sesion</button>");
	} else {
		
		out.println("<p>Actualmente la dirección de envío asociada a su cuenta es:</p>");
		out.println("<p style=\"color: brown;\">" + request.getSession().getAttribute("address") + "</p>");
		out.println("<p>Pulse comprar para realizar la compra.</p>");
		out.println("<button type=\"button\" onclick=\"location.href='compra'\">Comprar</button>");
		out.println("<form name=\"login\" action=\"./modificardireccion\" method=\"get\"><p>Si desea modificar la dirección en nuestra base de datos, rellene los siguientes datos y pulse el botón modificar para cambiarla.</p>");
		out.println("<p>Dirección:</p>\r\n"
				+ "    <input type=\"text\" name=\"address\" id=\"address\">\r\n"
				+ "\r\n"
				+ "    <p>Provincia:</p>\r\n"
				+ "        <select required name=\"state\" id=\"state\" class=\"form-control\">\r\n"
				+ "            <option value=\"0\" label=\"Elige la provincia\" selected=\"selected\">Elige la provincia</option>\r\n"
				+ "            <option value=\"Álava/Araba\">Álava/Araba</option>\r\n"
				+ "            <option value=\"Albacete\">Albacete</option>\r\n"
				+ "            <option value=\"Alicante\">Alicante</option>\r\n"
				+ "            <option value=\"Almería\">Almería</option>\r\n"
				+ "            <option value=\"Asturias\">Asturias</option>\r\n"
				+ "            <option value=\"Ávila\">Ávila</option>\r\n"
				+ "            <option value=\"Badajoz\">Badajoz</option>\r\n"
				+ "            <option value=\"Baleares\">Baleares</option>\r\n"
				+ "            <option value=\"Barcelona\">Barcelona</option>\r\n"
				+ "            <option value=\"Burgos\">Burgos</option>\r\n"
				+ "            <option value=\"Cáceres\">Cáceres</option>\r\n"
				+ "            <option value=\"Cádiz\">Cádiz</option>\r\n"
				+ "            <option value=\"Cantabria\">Cantabria</option>\r\n"
				+ "            <option value=\"Castellón\">Castellón</option>\r\n"
				+ "            <option value=\"Ceuta\">Ceuta</option>\r\n"
				+ "            <option value=\"Ciudad Real\">Ciudad Real</option>\r\n"
				+ "            <option value=\"Córdoba\">Córdoba</option>\r\n"
				+ "            <option value=\"Cuenca\">Cuenca</option>\r\n"
				+ "            <option value=\"Gerona/Girona\">Gerona/Girona</option>\r\n"
				+ "            <option value=\"Granada\">Granada</option>\r\n"
				+ "            <option value=\"Guadalajara\">Guadalajara</option>\r\n"
				+ "            <option value=\"Guipúzcoa/Gipuzkoa\">Guipúzcoa/Gipuzkoa</option>\r\n"
				+ "            <option value=\"Huelva\">Huelva</option>\r\n"
				+ "            <option value=\"Huesca\">Huesca</option>\r\n"
				+ "            <option value=\"Jaén\">Jaén</option>\r\n"
				+ "            <option value=\"La Coruña/A Coruña\">La Coruña/A Coruña</option>\r\n"
				+ "            <option value=\"La Rioja\">La Rioja</option>\r\n"
				+ "            <option value=\"Las Palmas\">Las Palmas</option>\r\n"
				+ "            <option value=\"León\">León</option>\r\n"
				+ "            <option value=\"Lérida/Lleida\">Lérida/Lleida</option>\r\n"
				+ "            <option value=\"Lugo\">Lugo</option>\r\n"
				+ "            <option value=\"Madrid\">Madrid</option>\r\n"
				+ "            <option value=\"Málaga\">Málaga</option>\r\n"
				+ "            <option value=\"Melilla\">Melilla</option>\r\n"
				+ "            <option value=\"Murcia\">Murcia</option>\r\n"
				+ "            <option value=\"Navarra\">Navarra</option>\r\n"
				+ "            <option value=\"Orense/Ourense\">Orense/Ourense</option>\r\n"
				+ "            <option value=\"Palencia\">Palencia</option>\r\n"
				+ "            <option value=\"Pontevedra\">Pontevedra</option>\r\n"
				+ "            <option value=\"Salamanca\">Salamanca</option>\r\n"
				+ "            <option value=\"Segovia\">Segovia</option>\r\n"
				+ "            <option value=\"Sevilla\">Sevilla</option>\r\n"
				+ "            <option value=\"Soria\">Soria</option>\r\n"
				+ "            <option value=\"Tarragona\">Tarragona</option>\r\n"
				+ "            <option value=\"Tenerife\">Tenerife</option>\r\n"
				+ "            <option value=\"Teruel\">Teruel</option>\r\n"
				+ "            <option value=\"Toledo\">Toledo</option>\r\n"
				+ "            <option value=\"Valencia\">Valencia</option>\r\n"
				+ "            <option value=\"Valladolid\">Valladolid</option>\r\n"
				+ "            <option value=\"Vizcaya/Bizkaia\">Vizcaya/Bizkaia</option>\r\n"
				+ "            <option value=\"Zamora\">Zamora</option>\r\n"
				+ "            <option value=\"Zaragoza\">Zaragoza</option>\r\n"
				+ "        </select>\r\n"
				+ "    \r\n"
				+ "    <p>Localidad:</p>\r\n"
				+ "    <input type=\"text\" name=\"city\" id=\"city\">\r\n"
				+ "  \r\n"
				+ "    <p>Código postal:</p>\r\n"
				+ "    <input type=\"text\" name=\"postalCode\" id=\"postalCode\">");
		out.println("<br><button type=\"submit\">Modificar</button></form>");
	}
	%>

    <script charset="utf-8">
        var TGSort = window.TGSort || function (n) { "use strict"; function r(n) { return n ? n.length : 0 } function t(n, t, e, o = 0) { for (e = r(n); o < e; ++o)t(n[o], o) } function e(n) { return n.split("").reverse().join("") } function o(n) { var e = n[0]; return t(n, function (n) { for (; !n.startsWith(e);)e = e.substring(0, r(e) - 1) }), r(e) } function u(n, r, e = []) { return t(n, function (n) { r(n) && e.push(n) }), e } var a = parseFloat; function i(n, r) { return function (t) { var e = ""; return t.replace(n, function (n, t, o) { return e = t.replace(r, "") + "." + (o || "").substring(1) }), a(e) } } var s = i(/^(?:\s*)([+-]?(?:\d+)(?:,\d{3})*)(\.\d*)?$/g, /,/g), c = i(/^(?:\s*)([+-]?(?:\d+)(?:\.\d{3})*)(,\d*)?$/g, /\./g); function f(n) { var t = a(n); return !isNaN(t) && r("" + t) + 1 >= r(n) ? t : NaN } function d(n) { var e = [], o = n; return t([f, s, c], function (u) { var a = [], i = []; t(n, function (n, r) { r = u(n), a.push(r), r || i.push(n) }), r(i) < r(o) && (o = i, e = a) }), r(u(o, function (n) { return n == o[0] })) == r(o) ? e : [] } function v(n) { if ("TABLE" == n.nodeName) { for (var a = function (r) { var e, o, u = [], a = []; return function n(r, e) { e(r), t(r.childNodes, function (r) { n(r, e) }) }(n, function (n) { "TR" == (o = n.nodeName) ? (e = [], u.push(e), a.push(n)) : "TD" != o && "TH" != o || e.push(n) }), [u, a] }(), i = a[0], s = a[1], c = r(i), f = c > 1 && r(i[0]) < r(i[1]) ? 1 : 0, v = f + 1, p = i[f], h = r(p), l = [], g = [], N = [], m = v; m < c; ++m) { for (var T = 0; T < h; ++T) { r(g) < h && g.push([]); var C = i[m][T], L = C.textContent || C.innerText || ""; g[T].push(L.trim()) } N.push(m - v) } t(p, function (n, t) { l[t] = 0; var a = n.classList; a.add("tg-sort-header"), n.addEventListener("click", function () { var n = l[t]; !function () { for (var n = 0; n < h; ++n) { var r = p[n].classList; r.remove("tg-sort-asc"), r.remove("tg-sort-desc"), l[n] = 0 } }(), (n = 1 == n ? -1 : +!n) && a.add(n > 0 ? "tg-sort-asc" : "tg-sort-desc"), l[t] = n; var i, f = g[t], m = function (r, t) { return n * f[r].localeCompare(f[t]) || n * (r - t) }, T = function (n) { var t = d(n); if (!r(t)) { var u = o(n), a = o(n.map(e)); t = d(n.map(function (n) { return n.substring(u, r(n) - a) })) } return t }(f); (r(T) || r(T = r(u(i = f.map(Date.parse), isNaN)) ? [] : i)) && (m = function (r, t) { var e = T[r], o = T[t], u = isNaN(e), a = isNaN(o); return u && a ? 0 : u ? -n : a ? n : e > o ? n : e < o ? -n : n * (r - t) }); var C, L = N.slice(); L.sort(m); for (var E = v; E < c; ++E)(C = s[E].parentNode).removeChild(s[E]); for (E = v; E < c; ++E)C.appendChild(s[v + L[E - v]]) }) }) } } n.addEventListener("DOMContentLoaded", function () { for (var t = n.getElementsByClassName("tg"), e = 0; e < r(t); ++e)try { v(t[e]) } catch (n) { } }) }(document)
    </script>
</body>
</html>