/**
 * 
 */
package com.cencosud.mobile.web.controller.financial;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencosud.mobile.web.controller.base.BaseController;
import com.cencosud.mobile.web.utils.DateUtils;
import com.cencosud.mobile.web.utils.StringUtils;
//import com.cencosud.mobile.web.validator.AdminUsersValidator;
import com.cencosud.mobile.core.ClienteRetiraServices;
import com.cencosud.mobile.core.CuadraturaOrdenCompraVentaCompServices;
import com.cencosud.mobile.core.CuadraturaVentaVerdeServices;
import com.cencosud.mobile.core.CumplimientokpiWebServices;
//import com.cencosud.mobile.core.CommerceServices;
import com.cencosud.mobile.core.DescripcionEmpresaServices;
import com.cencosud.mobile.core.EcommerceSoporteVentaServices;
import com.cencosud.mobile.core.EstadoCumpleResumenServices;
//import com.cencosud.mobile.core.EstadoCumpleResumenServices;
import com.cencosud.mobile.core.EstadoCumpleServices;
import com.cencosud.mobile.core.EstadoCumplimientoServices;
import com.cencosud.mobile.core.EstadoResponsableServices;
//import com.cencosud.mobile.core.EstadoCumplimientoServices;
//import com.cencosud.mobile.core.EstadoResponsableServices;
//import com.cencosud.mobile.core.FinancialInstitutionServices;
import com.cencosud.mobile.core.HorarioActualizacionStockServices;
import com.cencosud.mobile.core.HorarioServices;
import com.cencosud.mobile.core.HorarioTrazabilidadActualizacionServices;
import com.cencosud.mobile.core.HorarioVentaEnVerdeActualizacionServices;
//import com.cencosud.mobile.core.RoleServices;
import com.cencosud.mobile.core.TipoEstadoOrdenCompraStockServices;
import com.cencosud.mobile.core.TipoEstadoVentaEnVerdeServices;
import com.cencosud.mobile.core.TipoGuiaServices;
import com.cencosud.mobile.core.TipoOrdenServices;
import com.cencosud.mobile.core.TipoVentaServices;
import com.cencosud.mobile.core.UserServices;
import com.cencosud.mobile.core.VentaEmpresaServices;
import com.cencosud.mobile.core.util.PageNate;
import com.cencosud.mobile.dto.users.ClienteRetiraDTO;
import com.cencosud.mobile.dto.users.CuadraturaOrdenCompraVentaCompDTO;
import com.cencosud.mobile.dto.users.CuadraturaVentaVerdeDTO;
import com.cencosud.mobile.dto.users.DescripcionEmpresaDTO;
import com.cencosud.mobile.dto.users.EcommerceSoporteVentaDTO;
import com.cencosud.mobile.dto.users.EstadoCumpleDTO;
import com.cencosud.mobile.dto.users.EstadoCumpleResumenDTO;
import com.cencosud.mobile.dto.users.EstadoCumplimientoDTO;
import com.cencosud.mobile.dto.users.EstadoResponsableDTO;
import com.cencosud.mobile.dto.users.HorarioActualizacionStockDTO;
import com.cencosud.mobile.dto.users.HorarioDTO;
import com.cencosud.mobile.dto.users.HorarioTrazabilidadActualizacionDTO;
import com.cencosud.mobile.dto.users.HorarioVentaEnVerdeActualizacionDTO;
import com.cencosud.mobile.dto.users.TipoEstadoOrdenCompraStockDTO;
import com.cencosud.mobile.dto.users.TipoEstadoVentaEnVerdeDTO;
import com.cencosud.mobile.dto.users.TipoGuiaDTO;
import com.cencosud.mobile.dto.users.TipoOrdenDTO;
import com.cencosud.mobile.dto.users.TipoVentaDTO;
import com.cencosud.mobile.dto.users.UserDTO;
import com.cencosud.mobile.dto.users.VentaEmpresaDTO;

/**
 * @author JOSE
 *
 */

@Controller
public class FinancialController extends BaseController {
	
	private static Logger log = Logger.getLogger(FinancialController.class);

	//@Autowired
   	//private CuadraturaEcommerceServices cuadraturaEcommerceServicesImpl;
    
    //@Autowired
   	//private CuadraturaJpdTotDadServices cuadraturaJpdTotDadServicesImpl;
    @Autowired
	private UserServices userServicesImpl;
    
    @Autowired
   	private EcommerceSoporteVentaServices ecommerceSoporteVentaServicesImpl;
    
    @Autowired
	private TipoOrdenServices tipoOrdenServicesImpl;
    @Autowired
	private TipoVentaServices tipoVentaServicesImpl;
    @Autowired
	private ClienteRetiraServices clienteRetiraServicesImpl;
    @Autowired
	private DescripcionEmpresaServices descripcionEmpresaServicesImpl;
    @Autowired
	private TipoGuiaServices tipoGuiaServicesImpl;
    @Autowired
	private HorarioServices horarioServicesImpl;
    @Autowired
	private VentaEmpresaServices ventaEmpresaServicesImpl;
    @Autowired
   	private EstadoCumpleServices estadoCumpleServicesImpl;
    @Autowired
   	private EstadoCumpleResumenServices estadoCumpleResumenServicesImpl;
    @Autowired
   	private EstadoCumplimientoServices estadoCumplimientoServicesImpl;    
    @Autowired
   	private EstadoResponsableServices estadoResponsableServicesImpl;
    
    @Autowired
   	private CumplimientokpiWebServices cumplimientokpiWebServicesImpl;
    
    @Autowired
   	private TipoEstadoVentaEnVerdeServices tipoEstadoVentaEnVerdeServicesImpl;
    
    @Autowired
   	private HorarioVentaEnVerdeActualizacionServices horarioVentaEnVerdeActualizacionServicesImpl;
   
    @Autowired
   	private CuadraturaVentaVerdeServices cuadraturaVentaVerdeServicesImpl;
    
    @Autowired
   	private HorarioActualizacionStockServices horarioActualizacionStockServicesImpl;
    
    @Autowired
   	private HorarioTrazabilidadActualizacionServices horarioTrazabilidadActualizacionServicesImpl;
   

    @RequestMapping(value = "**/financial/trazabilidad", method = RequestMethod.GET)
    public ModelAndView trazabilidad(String posted, String fromstatsday_sday, String fromstatsmonth_sday, String dateInicio) {
    	log.info("home:trazabilidad");
    	//UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
 		String iFechaFin = ft.format(now);
 		log.info("home:posted="+posted);
 		log.info("home:fromstatsday_sday="+fromstatsday_sday);
 		log.info("home:fromstatsmonth_sday="+ fromstatsmonth_sday);
 		log.info("home:dateInicio="+ dateInicio);
 		log.info("Function="+ DateUtils.restarDiaFecha(iFechaFin,"0"));
 		log.info("Function2="+ DateUtils.turnDate3(DateUtils.restarDiaFecha(iFechaFin,"0")));
 		//String starttime = DateUtils.turnDate3(dateInicio) != null?DateUtils.turnDate3(dateInicio):iFechaFin;
 		String starttime = DateUtils.turnDate3(dateInicio) != null?DateUtils.turnDate3(dateInicio):DateUtils.turnDate3(DateUtils.restarDiaFecha(iFechaFin,"1"));

 		log.info("home:starttime="+ starttime);
 		//cantida soporte venta
 		int cantSoporte = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "2", "0", null, "99999999");

 		//Eom Encontrados (Soporte de venta se debería buscar con la query EOM (OD_EOM- SKU) )
 		//int cantSoporteVentaEomFind = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomFindCounts(starttime, null, "3", "0", null, null, "99999999");
 		int cantSoporteVentaEomFind = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomFindCounts(starttime, "1", "3", "0", null, null, "99999999");
 		
 		//Diferencias Eom No encontrados 
 		//int cantSoporteVentaEomDif = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifCounts(starttime, null, "3", "0", null, null, null);
 		int cantSoporteVentaEomDif = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifCounts(starttime, "0", "3", null, null, null, null);

 		//Diferencias Wms No encontrados 
 		int cantSoporteVentaWms = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaWmsCounts(starttime, "1", "4", null, null, null);
 		int cantSoporteVentaWmsDif = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaWmsDifCounts(starttime, "1", "4", null, null, null);

 		//Diferencias Jda No encontrados 
 		int cantSoporteVentaJda = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaJdaCounts(starttime, "1", "4", null, null, null);
 		int cantSoporteVentaJdaDif = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaJdaDifCounts(starttime, "1", "4", null, null, null);
 		List<HorarioTrazabilidadActualizacionDTO> horarios = horarioTrazabilidadActualizacionServicesImpl.getHorarioTrazabilidadActualizacions(0, 1);
 		
 		
 		log.info("cantSoporte="+ cantSoporte);
 		log.info("cantSoporteVentaEomFind="+ cantSoporteVentaEomFind);
 		log.info("cantSoporteVentaEomDif="+ cantSoporteVentaEomDif);
 		log.info("cantSoporteVentaWms="+ cantSoporteVentaWms);
 		log.info("cantSoporteVentaWmsDif="+ cantSoporteVentaWmsDif);
 		log.info("cantSoporteVentaJda="+ cantSoporteVentaJda);
 		log.info("cantSoporteVentaJdaDif="+ cantSoporteVentaJdaDif);
 		
 		

 		Map<String, Object> model = new HashMap<String, Object>();
 		model.put("posted", posted);//
 		model.put("cantSoporte", cantSoporte);//
 		model.put("cantSoporteVentaEomFind", cantSoporteVentaEomFind);//
 		model.put("cantSoporteVentaEomDif", cantSoporteVentaEomDif);//
 		model.put("cantSoporteVentaWms", cantSoporteVentaWms);//
 		model.put("cantSoporteVentaWmsDif", cantSoporteVentaWmsDif);//
 		model.put("cantSoporteVentaJda", cantSoporteVentaJda);//
 		model.put("cantSoporteVentaJdaDif", cantSoporteVentaJdaDif);//
 		model.put("fecha", DateUtils.turnDate5(starttime));//
 		model.put("namePage", "trazabilidad");//
 		model.put("horarios", horarios);
 		return new ModelAndView("role/financial/trazabilidad", model);
     }
    
    @RequestMapping(value = "**/financial/soporteVentaDetalle", method = RequestMethod.GET)
    public ModelAndView soporteVentaDetalle(String dateInicio, String estado) {
    	log.info("home:soporteVentaDetalle");
    	//UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
 		String iFechaFin = ft.format(now);
 		String starttime = dateInicio;
 		
 		if ( (dateInicio != null && dateInicio != "")){
 			 starttime = dateInicio;
 		} else {
 			 starttime = iFechaFin;
 		}
 		log.info("home:dateInicio="+ dateInicio);
 		
 		
 		//Post Jhonson
 		int cantSoporteVentaPosJhonson = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCountsPosJhonson(starttime, null, "2", "0", "400", "99999999");
 		//Post Paris
 		int cantSoporteVentaPosParis = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCountsPosParis(starttime, null, "2", "0", "400", "99999999");
 		//Paris.cl
 		int cantSoporteVentaPosParisCl = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCountsPosParisCl(starttime, null, "2", "0", "32", "99999999");
 		//Diferencias Soporte Ventas VS Ecommerce
 		int dif = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "0", "1", null, null, null);
 		//cantidad Ecommerce
 		int cantEcommerce = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "1", null, null, "99999999");
 		List<HorarioTrazabilidadActualizacionDTO> horarios = horarioTrazabilidadActualizacionServicesImpl.getHorarioTrazabilidadActualizacions(0, 1);
 		
 		
 		log.info("home:starttime="+ starttime);
 		log.info("home:iFechaFin="+ iFechaFin);
 		log.info("home:cantSoporteVentaPosJhonson="+ cantSoporteVentaPosJhonson);
 		log.info("home:cantSoporteVentaPosParis="+ cantSoporteVentaPosParis);
 		log.info("home:cantSoporteVentaPosParisCl="+ cantSoporteVentaPosParisCl);
 		log.info("home:ecommerceSoporteVentaServicesImpl="+ ecommerceSoporteVentaServicesImpl);
 		Map<String, Object> model = new HashMap<String, Object>();
 		model.put("cantSoporteVentaPosJhonson", cantSoporteVentaPosJhonson);//
 		model.put("cantSoporteVentaPosParis", cantSoporteVentaPosParis);//
		model.put("cantSoporteVentaPosParisCl", cantSoporteVentaPosParisCl);//
		model.put("dif", dif);//
		model.put("cantEcommerce", cantEcommerce);//
 		model.put("fecha", DateUtils.turnDate5(starttime));//
 		model.put("namePage", "trazabilidad");//
 		model.put("horarios", horarios);
 		return new ModelAndView("role/financial/soporteVentaDetalle", model);
     }
    
    
    @RequestMapping(value = "**/financial/detalleNoEncontradoSoporteVenta", method = RequestMethod.GET)
	public ModelAndView detalleNoEncontradoSoporteVenta(Integer p, String dateInicio, String estado) {
    	log.info("home:detalleNoEncontradoSoporteVenta");
    	
 		Date now = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("YYYYMMdd");
		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		String dateInicio2 = null;
		int total;
		if ("".equals(dateInicio) || dateInicio == null ) {
			dateInicio2 = iFechaFin;
			
			
		} else {
			dateInicio2 = dateInicio;
		}
		log.info("dateInicio2:"+dateInicio2);
		
		String starttime = dateInicio2;
		String starttime2 = DateUtils.turnDate4(dateInicio2) != null?DateUtils.turnDate4(dateInicio2):DateUtils.turnDate4(iFechaFin);

		log.info("home:starttime="+starttime);
		log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado="+estado);
		log.info("home:starttime="+DateUtils.restarDiaFecha2(fecha,"0"));
		log.info("home:fecha="+fecha);
		log.info("home:estado="+estado);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);
		
		total = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaPaginador(starttime, "0", "1", null, null);
		log.info("total="+ total);
		
		
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
		
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		if (estado != null)
			qstr += "&estado="+estado;
		else
			qstr += "";
		
		
		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleNoEncontradoSoporteVenta", qstr);
		
		log.info("getStart:"+pageNate.getStart());
		log.info("getLimit:"+pageNate.getLimit());

		
		
		List<EcommerceSoporteVentaDTO> detalles = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentas(starttime, "0", "1", null, null, 0, 1000000000);
		
		
		
		int cantEcommerce = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "0", "1", null, null, null);
		int cantSoporte = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "0", "1", null, null, "99999999");
		int cantSoporteVentaNoEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "0", "1", null, null, null);
		int cantSoporteVentaEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "1", "1", null, null, null);
		int cantSoporteVenta = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "2", null, null, null);
		List<HorarioTrazabilidadActualizacionDTO> horarios = horarioTrazabilidadActualizacionServicesImpl.getHorarioTrazabilidadActualizacions(0, 1);
 		
		log.info("home:starttime="+ starttime);
 		log.info("home:cantEcommerce="+ cantEcommerce);
 		log.info("home:cantSoporte="+ cantSoporte);
 		log.info("home:cantSoporteVentaNoEncontrados="+ cantSoporteVentaNoEncontrados);
 		log.info("home:cantSoporteVentaEncontrados="+ cantSoporteVentaEncontrados);
 		log.info("home:cantSoporteVenta="+ cantSoporteVenta);
 		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantEcommerce", cantEcommerce);//
		model.put("cantSoporte", cantSoporte);//
		model.put("cantSoporteVentaNoEncontrados", cantSoporteVentaNoEncontrados);//
		model.put("cantSoporteVentaEncontrados", cantSoporteVentaEncontrados);//
		model.put("cantSoporteVenta", cantSoporteVenta);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		
		
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("namePage", "trazabilidad");//
		model.put("horarios", horarios);
		return new ModelAndView("role/financial/detalleNoEncontradoSoporteVenta", model);
    }
    
    
    @RequestMapping(value = "**/financial/eom", method = RequestMethod.GET)
    public ModelAndView eom(String posted, String fromstatsday_sday, String fromstatsmonth_sday, String dateInicio) {
    	log.info("home:eom");
    	//UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	log.info("home:posted="+posted);
 		log.info("home:fromstatsday_sday="+fromstatsday_sday);
 		log.info("home:fromstatsmonth_sday="+ fromstatsmonth_sday);
 		log.info("home:dateInicio="+ dateInicio);
 		Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
 		String iFechaFin = ft.format(now);
 		String dateInicio2 = null;
 		if ("".equals(dateInicio) || dateInicio == null ) {
			dateInicio2 = iFechaFin;
			
			
		} else {
			dateInicio2 = dateInicio;
		}
		log.info("dateInicio2:"+dateInicio2);
 		
 		log.info("home:Function="+ DateUtils.restarDiaFecha(iFechaFin,"0"));
 		log.info("home:Function2="+ DateUtils.turnDate3(DateUtils.restarDiaFecha(iFechaFin,"0")));
 		String starttime = dateInicio2 != null?dateInicio2:DateUtils.turnDate3(DateUtils.restarDiaFecha(iFechaFin,"0"));
 		//String fecha, String estado, String estadoRelacion, String coddesp, String canVend, String subEstoc, String sku
 		//int dif = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifCounts(starttime, null, "3", "0", null, "4", "99999999");
 		//int dif = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifCounts(starttime, "0", "3", "0", null, null, "99999999");
 		int dif = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifCounts(starttime, "0", "3", "0", null, null, "99999999");
 		int bopis = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCountsEomDad(starttime, "1", "3", "0", null, "1", "99999999");
 		int clickAndCollect = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCountsEomDad(starttime,"1", "3", "0", null, "2", "99999999");
 		int dad = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCountsEomDad(starttime, "1", "3", "0", null, "3", "99999999");
 		List<HorarioTrazabilidadActualizacionDTO> horarios = horarioTrazabilidadActualizacionServicesImpl.getHorarioTrazabilidadActualizacions(0, 1);
 		
 		log.info("home:starttime="+ starttime);
 		log.info("home:bopis="+ bopis);
 		log.info("home:clickAndCollect="+ clickAndCollect);
 		log.info("home:dad="+ dad);
 		log.info("home:dif="+ dif);
 		
 		Map<String, Object> model = new HashMap<String, Object>();
 		model.put("dif", dif);//
 		model.put("bopis", bopis);//
 		model.put("bopis", bopis);//
 		model.put("clickAndCollect", clickAndCollect);//
 		model.put("dad", dad);//
 		model.put("starttime", starttime);//
 		model.put("fecha", DateUtils.turnDate5(starttime));//
 		model.put("namePage", "trazabilidad");// 	
 		model.put("horarios", horarios);
 		return new ModelAndView("role/financial/eom", model);
     }
    
    @RequestMapping(value = "**/financial/detalleNoEncontradoSoporteVentaEom", method = RequestMethod.GET)
	public ModelAndView detalleNoEncontradoSoporteVentaEom(Integer p, String dateInicio, String estado) {
    	log.info("home:detalleNoEncontradoSoporteVentaEom");
    	//UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	log.info("p:"+p);
    	log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado="+estado);
 		
 		
 		Date now = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("YYYYMMdd");
		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		String dateInicio2 = null;
		int total;
		
		
		if ("".equals(dateInicio) || dateInicio == null ) {
			dateInicio2 = iFechaFin;
			
			
		} else {
			dateInicio2 = dateInicio;
		}
		log.info("dateInicio2:"+dateInicio2);
		
		
		
		log.info("home:starttime="+DateUtils.restarDiaFecha2(fecha,"0"));
		String starttime = dateInicio2;
		log.info("home:starttime="+starttime);
		String starttime2 = DateUtils.turnDate4(dateInicio2) != null?DateUtils.turnDate4(dateInicio2):DateUtils.turnDate4(iFechaFin);
		log.info("home:fecha="+fecha);
		log.info("home:estado="+estado);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);

		total = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifPaginador(starttime, "0", "3", "0", null, null, "99999999");
		log.info("total="+total);
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
		
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		if (estado != null)
			qstr += "&estado="+estado;
		else
			qstr += "";
		
	
		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleNoEncontradoSoporteVentaEom", qstr);
		
		
		List<EcommerceSoporteVentaDTO> detalles = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifs(starttime, "0", "3", "0", null, null, "99999999", 0, 1000000000);
		int cantEcommerce = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "0", "1", null, null, null);
		int cantSoporte = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "0", "1", null, null, "99999999");
		//int cantSoporteVentaNoEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "0", "1", null, null);
		//int cantSoporteVentaNoEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifCounts(starttime, null, "3", "0", null, "4", "99999999");
		int cantSoporteVentaNoEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaEomDifCounts(starttime, "0", "3", "0", null, null, "99999999");
		int cantSoporteVentaEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "1", "1", null, null, null);
		int cantSoporteVenta = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "2", null, null, "99999999");
		List<HorarioTrazabilidadActualizacionDTO> horarios = horarioTrazabilidadActualizacionServicesImpl.getHorarioTrazabilidadActualizacions(0, 1);
 		
		log.info("home:starttime="+ starttime);
 		log.info("home:cantEcommerce="+ cantEcommerce);
 		log.info("home:cantSoporte="+ cantSoporte);
 		log.info("home:cantSoporteVentaNoEncontrados="+ cantSoporteVentaNoEncontrados);
 		log.info("home:cantSoporteVentaEncontrados="+ cantSoporteVentaEncontrados);
 		log.info("home:cantSoporteVenta="+ cantSoporteVenta);
 		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantEcommerce", cantEcommerce);//
		model.put("cantSoporte", cantSoporte);//
		model.put("cantSoporteVentaNoEncontrados", cantSoporteVentaNoEncontrados);//
		model.put("cantSoporteVentaEncontrados", cantSoporteVentaEncontrados);//
		model.put("cantSoporteVenta", cantSoporteVenta);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("namePage", "trazabilidad");//	
		model.put("horarios", horarios);
		return new ModelAndView("role/financial/detalleNoEncontradoSoporteVentaEom", model);
    }
    
    @RequestMapping(value = "**/financial/detalleNoEncontradoWms", method = RequestMethod.GET)
	public ModelAndView detalleNoEncontradoWms(Integer p, String dateInicio, String estado) {
    	log.info("home:detalleNoEncontradoWms");
    	//UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Date now = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("YYYYMMdd");
		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		String dateInicio2 = null;
		
		if ("".equals(dateInicio) || dateInicio == null ) {
			dateInicio2 = iFechaFin;
			
			
		} else {
			dateInicio2 = dateInicio;
		}
		log.info("dateInicio2:"+dateInicio2);
		
		String starttime = dateInicio2;
		String starttime2 = null;//DateUtils.turnDate4(dateInicio) != null?DateUtils.turnDate4(dateInicio):DateUtils.turnDate4(iFechaFin);
		int total;
		log.info("p:"+p);
		log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado="+estado);
		log.info("starttime="+starttime);
		log.info("starttime2="+starttime2);
		log.info("home:iFechaFin="+iFechaFin);
		log.info("home:fecha="+fecha);
		log.info("home:estado="+estado);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);
		log.info("home:starttime2="+ starttime2);
		
		
		total = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaWmsDifPaginador(starttime, "1", "4", null, null, null, null);
		log.info("total:"+total);
		
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
	
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		
		
		if (estado != null )
			qstr += "&estado="+estado;
		else
			qstr += "";
		
		
		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleNoEncontradoWms", qstr);
		
		log.info("Start:"+pageNate.getStart());
		log.info("End:"+pageNate.getLimit());
		
		
		List<EcommerceSoporteVentaDTO> detalles = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaWmsDifs(starttime, "1", "4", null, null, null, null, 0, 1000000000);
		int cantEcommerce = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "1", null, null, null);
		int cantSoporte = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "2", null, null, "99999999");
		int cantSoporteVentaNoEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaWmsDifCounts(starttime, "1", "4", null, null, null);
		int cantSoporteVentaEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "1", "1", null, null, null);
		int cantSoporteVenta = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "2", null, null, null);
		List<HorarioTrazabilidadActualizacionDTO> horarios = horarioTrazabilidadActualizacionServicesImpl.getHorarioTrazabilidadActualizacions(0, 1);
 		
		log.info("home:detalles="+ detalles);
		log.info("home:cantEcommerce="+ cantEcommerce);
 		log.info("home:cantSoporte="+ cantSoporte);
 		log.info("home:cantSoporteVentaNoEncontrados="+ cantSoporteVentaNoEncontrados);
 		log.info("home:cantSoporteVentaEncontrados="+ cantSoporteVentaEncontrados);
 		log.info("home:cantSoporteVenta="+ cantSoporteVenta);
 		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantEcommerce", cantEcommerce);//
		model.put("cantSoporte", cantSoporte);//
		model.put("cantSoporteVentaNoEncontrados", cantSoporteVentaNoEncontrados);//
		model.put("cantSoporteVentaEncontrados", cantSoporteVentaEncontrados);//
		model.put("cantSoporteVenta", cantSoporteVenta);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("namePage", "trazabilidad");//		
		model.put("horarios", horarios);
		return new ModelAndView("role/financial/detalleNoEncontradoWms", model);
    }
    
    @RequestMapping(value = "**/financial/detalleNoEncontradoJda", method = RequestMethod.GET)
	public ModelAndView detalleNoEncontradoJda(Integer p, String dateInicio, String estado) {
    	log.info("home:detalleNoEncontradoWms");
    	//UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado="+estado);
 		log.info("p:"+p);
 		
 		Date now = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("YYYYMMdd");
		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		String dateInicio2 = null;
		int total;	
		
		
		if ("".equals(dateInicio) || dateInicio == null ) {
			dateInicio2 = iFechaFin;
			
			
		} else {
			dateInicio2 = dateInicio;
		}
		log.info("dateInicio2:"+dateInicio2);
		
		log.info("starttime="+DateUtils.restarDiaFecha2(fecha,"0"));
		String starttime = dateInicio2;
		log.info("starttime="+starttime);
		String starttime2 = DateUtils.turnDate4(dateInicio2) != null?DateUtils.turnDate4(dateInicio2):DateUtils.turnDate4(iFechaFin);
		log.info("home:fecha="+fecha);
		log.info("home:estado="+estado);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);
		
		total = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaJdaDifPaginador(starttime, "1", "4", null, null, null, null);
		log.info("total:"+total);
		
		
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		if (estado != null)
			qstr += "&estado="+estado;
		else
			qstr += "";
		

		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleNoEncontradoWms", qstr);
		
		log.info("Start:"+pageNate.getStart());
		log.info("End:"+ pageNate.getLimit());
		List<EcommerceSoporteVentaDTO> detalles = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaJdaDifs(starttime, "1", "4", null, null, null, null, 0, 1000000000);
		int cantEcommerce = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "1", null, null, null);
		int cantSoporte = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "2", null, null, "99999999");
		int cantSoporteVentaNoEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaJdaDifCounts(starttime, "1", "4", null, null, null);
		int cantSoporteVentaEncontrados = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, "1", "1", null, null, null);
		int cantSoporteVenta = ecommerceSoporteVentaServicesImpl.getEcommerceSoporteVentaCounts(starttime, null, "2", null, null, null);
		List<HorarioTrazabilidadActualizacionDTO> horarios = horarioTrazabilidadActualizacionServicesImpl.getHorarioTrazabilidadActualizacions(0, 1);
 		
		log.info("home:starttime="+ starttime);
 		log.info("home:cantEcommerce="+ cantEcommerce);
 		log.info("home:cantSoporte="+ cantSoporte);
 		log.info("home:cantSoporteVentaNoEncontrados="+ cantSoporteVentaNoEncontrados);
 		log.info("home:cantSoporteVentaEncontrados="+ cantSoporteVentaEncontrados);
 		log.info("home:cantSoporteVenta="+ cantSoporteVenta);
 		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantEcommerce", cantEcommerce);//
		model.put("cantSoporte", cantSoporte);//
		model.put("cantSoporteVentaNoEncontrados", cantSoporteVentaNoEncontrados);//
		model.put("cantSoporteVentaEncontrados", cantSoporteVentaEncontrados);//
		model.put("cantSoporteVenta", cantSoporteVenta);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("namePage", "trazabilidad");//		
		model.put("horarios", horarios);
		return new ModelAndView("role/financial/detalleNoEncontradoJda", model);
    }
    
    @RequestMapping(value = "**/financial/panelEstatico", method = RequestMethod.GET)
    public ModelAndView panelDinamico(String tipo_orden, String tipo_venta, String cliente_retira,  String descripcion_empresa, String tipo_guia, String tipo_horario, String venta_empresa, String tipo_estado, String dateInicio, String cumplimiento, String cumple_resumen, String responsable) {
		//UserDTO principal = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("user:allUsers Usuario Actual "+principal.getUsername());
		//log.info("posted"+posted);
		log.info("user:tipo_orden="+tipo_orden);
		log.info("user:tipo_venta="+ tipo_venta);
		log.info("user:cliente_retira="+cliente_retira);
		log.info("user:descripcion_empresa="+descripcion_empresa);
		log.info("user:tipo_guia="+tipo_guia);
		log.info("user:tipo_horario="+tipo_horario);
		log.info("user:venta_empresa="+venta_empresa);
		log.info("user:tipo_estado="+tipo_estado);
		log.info("user:dateInicio="+dateInicio);
		log.info("user:cumplimiento="+cumplimiento);
		log.info("user:cumple_resumen="+cumple_resumen);
		log.info("user:responsable="+responsable);    	
    	//UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		String currentDate = ft.format(dNow);
		log.info("currentDate="+currentDate);
		//log.info("Date="+DateUtils.turnDate(DateUtils.restarDiaFecha(currentDate,"1")));
		
		
		//String dateInicio =  dateInicio;
		//out.println("dateInicio="+dateInicio);
		
		String starttime = DateUtils.turnDate(dateInicio) != null?DateUtils.turnDate(dateInicio): DateUtils.turnDate(DateUtils.restarDiaFecha(currentDate,"1"));
		
		//String starttime = DateUtils.turnDate(dateInicio) != null?DateUtils.turnDate(dateInicio):DateUtils.turnDate(currentDate);
		//out.println("starttime"+starttime);
		log.info("user:starttime="+starttime);
		//log.info("user:starttime2="+starttime2);

		String orden = null;
		String venta = "";
		String guia = "";
		
		if (!"".equals(tipo_orden)) {
			orden = tipo_orden;
		} else {
			orden = null;
		}
		
		
		if (!"".equals(tipo_venta)) {
			venta = tipo_venta;
		} else {
			venta = null;
		}
		
		
		if (!"".equals(tipo_guia)) {
			guia = tipo_guia;
		} else {
			guia = null;
		}
		
		
		
		log.info("orden="+orden);
		log.info("venta="+venta);
		log.info("guia="+guia);
		
		
 		
 		List<UserDTO> users = userServicesImpl.getUsers();
		List<TipoOrdenDTO> ordenes = tipoOrdenServicesImpl.getTipoOrdens();
		List<TipoVentaDTO> ventas = tipoVentaServicesImpl.getTipoVentas();
		List<ClienteRetiraDTO> clientes = clienteRetiraServicesImpl.getClienteRetiras();
		List<DescripcionEmpresaDTO> empresas = descripcionEmpresaServicesImpl.getDescripcionEmpresas();
		List<TipoGuiaDTO> guias = tipoGuiaServicesImpl.getTipoGuias();
		List<HorarioDTO> horarios = horarioServicesImpl.getHorarios();
		List<VentaEmpresaDTO> ventaempresas = ventaEmpresaServicesImpl.getVentaEmpresas();
		List<EstadoCumpleDTO> estadocumples = estadoCumpleServicesImpl.getEstadoCumples();
		List<EstadoCumpleResumenDTO> estadocumpleresumens = estadoCumpleResumenServicesImpl.getEstadoCumpleResumens();
		List<EstadoCumplimientoDTO> estadocumplimientos = estadoCumplimientoServicesImpl.getEstadoCumplimientos();
		List<EstadoResponsableDTO> estadoresponsables = estadoResponsableServicesImpl.getEstadoResponsables();
		
		
		
		
 		
		String prefixclause = null;
		
		log.info("orden="+orden);
		log.info("venta="+venta);
		log.info("guia="+guia);
 		//cantidad Cumple
 		int cantCumple = cumplimientokpiWebServicesImpl.getCumpleokpiWebCounts(starttime, starttime, orden, venta, guia, "1", prefixclause);
 		//cantidad Atrasado
 		int cantAtrasado = cumplimientokpiWebServicesImpl.getCumpleokpiWebCounts(starttime, starttime, orden, venta, guia, "2", prefixclause);
 		//cantidad No cumple
 		int cantNoCumple = cumplimientokpiWebServicesImpl.getCumpleokpiWebCounts(starttime, starttime, orden, venta, guia, "3", prefixclause);
 		//Total cantidad
 		int cantTotal = cumplimientokpiWebServicesImpl.getTotalkpiWebCounts(starttime, starttime, orden, venta, guia, null, prefixclause);
 		
 		
 		float porcentajeCumple = 0;
		if (cantCumple == 0 && cantTotal == 0) {
			System.out.println("-");
			porcentajeCumple = 0;
		} else {
			porcentajeCumple = ((float ) ( (float ) cantCumple / (float )cantTotal) * 100);
			DecimalFormat df = new DecimalFormat("0.00"); 
			System.out.println("->"+df.format(porcentajeCumple));
		}
 		String sporcentajeCumple = Float.toString(porcentajeCumple);
 		
 		
 		float porcentajeAtrasado = 0;
		if (cantAtrasado == 0 && cantTotal == 0) {
			System.out.println("-");
			porcentajeAtrasado = 0;
		} else {
			porcentajeAtrasado = ((float ) ( (float ) cantAtrasado / (float )cantTotal) * 100);
			DecimalFormat df = new DecimalFormat("0.00"); 
			System.out.println("->"+df.format(porcentajeAtrasado));
		}
 		String sporcentajeAtrasado = Float.toString(porcentajeAtrasado);
		
 		
 		float porcentajeNoCumple = 0;
		if (cantNoCumple == 0 && cantTotal == 0) {
			System.out.println("-");
			porcentajeNoCumple = 0;
		} else {
			porcentajeNoCumple = ((float ) ( (float ) cantNoCumple / (float )cantTotal) * 100);
			DecimalFormat df = new DecimalFormat("0.00"); 
			System.out.println("->"+df.format(porcentajeNoCumple));
		}
 		String sporcentajeNoCumple = Float.toString(porcentajeNoCumple);
 		
 		
 		float porcentajeTotal = 0;
		if (cantTotal == 0) {
			System.out.println("-");
			porcentajeTotal = 0;
		} else {
			porcentajeTotal = ((float ) ( (float ) cantTotal / (float )cantTotal) * 100);
			DecimalFormat df = new DecimalFormat("0.00"); 
			System.out.println("->"+df.format(porcentajeTotal));
		}
 		String sporcentajeTotal = Float.toString(porcentajeTotal);
 		
 		
 		log.info("starttime="+ starttime);
 		log.info("cantCumple="+ cantCumple);
 		log.info("cantCumple="+ cantCumple);
 		log.info("==1=="+ StringUtils.Redondear(sporcentajeCumple,2));
 		
 		
 		
 		sporcentajeCumple.replace(".","");
 		log.info("==2=="+ sporcentajeCumple.replace(".",""));

 		
 		
 		
 		
 		log.info("porcentajeCumple=" + StringUtils.Redondear(String.valueOf(""+porcentajeCumple),2));
 		log.info("cantAtrasado="+ cantAtrasado);
 		log.info("cantNoCumple="+ cantNoCumple);
 		
 		Map<String, Object> model = new HashMap<String, Object>();
 		//model.put("posted", posted);//
 		model.put("cantCumple", cantCumple);//
 		model.put("porcentajeCumple", StringUtils.Redondear(sporcentajeCumple,2));//

 		model.put("cantAtrasado", cantAtrasado);//
 		model.put("porcentajeAtrasado", StringUtils.Redondear(sporcentajeAtrasado,2));//
 		
 		model.put("cantNoCumple", cantNoCumple);//
 		model.put("porcentajeNoCumple", StringUtils.Redondear(sporcentajeNoCumple,2));//

 		model.put("cantTotal", cantTotal);
 		model.put("porcentajeTotal", StringUtils.Redondear(sporcentajeTotal,2));//
 		model.put("test", sporcentajeCumple.replace(".",""));//
		//model.put("posted", posted);
		model.put("users", users);
		model.put("ordenes", ordenes);
		model.put("ventas", ventas);
		model.put("clientes", clientes);
		model.put("empresas", empresas);
		model.put("guias", guias);
		model.put("horarios", horarios);
		model.put("ventaempresas", ventaempresas);
		model.put("estadocumples", estadocumples);
		model.put("estadocumpleresumens", estadocumpleresumens);
		model.put("estadocumplimientos", estadocumplimientos);
		model.put("estadoresponsables", estadoresponsables);
 		model.put("fecha", DateUtils.turnDate5(starttime));//
 		model.put("namePage", "panelEstatico");//
 		
 		
 		
 		return new ModelAndView("role/financial/panelEstatico", model);
     }
    
    
    @RequestMapping(value = "**/financial/reporteCuadraturaVentaEnVerde", method = RequestMethod.GET)
    public ModelAndView reporteCuadraturaEnVerde(String posted, String dateInicio, String dateFin, String estado) {
		log.info("user:reporteCuadraturaVentaEnVerde");
		//UserDTO principal = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("user:allUsers Usuario Actual "+principal.getUsername());
		log.info("user:posted="+posted);
		log.info("user:dateInicio="+dateInicio);
		log.info("user:dateFin="+ dateFin);
		log.info("estado="+estado);
		
		Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
 		String iFechaFin = ft.format(now);
 		log.info("home:posted="+posted);
 		log.info("home:dateInicio="+ dateInicio);
 		log.info("Function="+ DateUtils.restarDiaFecha(iFechaFin,"0"));
 		log.info("Function2="+ DateUtils.turnDate3(DateUtils.restarDiaFecha(iFechaFin,"0")));
 		//String starttime = DateUtils.turnDate3(dateInicio) != null?DateUtils.turnDate3(dateInicio):iFechaFin;
 		String starttime = DateUtils.turnDateVentaVerde(dateInicio) != null?DateUtils.turnDateVentaVerde(dateInicio):DateUtils.turnDateVentaVerde(iFechaFin);
		log.info("user:starttime="+starttime);

		List<HorarioActualizacionStockDTO> horarios = horarioActualizacionStockServicesImpl.getHorarioActualizacionStocks(0, 1);
		List<CuadraturaVentaVerdeDTO> listado = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime, "1", 0, 100);
		
		int eom = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime+" 00:00:00",starttime+" 23:59:59", "1");
		int encontrado = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime+" 00:00:00",starttime+" 23:59:59", "2");
		int noEncontrado = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime+" 00:00:00",starttime+" 23:59:59", "3");
		int ocConError = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime+" 00:00:00",starttime+" 23:59:59", "4");
		int cantidadOc = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime+" 00:00:00",starttime+" 23:59:59", "5");

		log.info("eom="+eom);
		log.info("encontrado="+encontrado);
		log.info("noEncontrado="+noEncontrado);
		log.info("ocConError="+ocConError);
		log.info("cantidadOc="+cantidadOc);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("posted", posted);//
		model.put("eom", eom);//
		model.put("encontrado", encontrado);//
		model.put("noEncontrado", noEncontrado);//
		model.put("ocConError", ocConError);//
		model.put("cantidadOc", cantidadOc);//
		model.put("horarios", horarios);//
		model.put("namePage", "ventaEnVerde");//
		
		
		return new ModelAndView("role/financial/reporteCuadraturaVentaEnVerde", model);
    }
    
    
    @RequestMapping(value = "**/financial/detalleOcEom", method = RequestMethod.GET)
    public ModelAndView detalleOC(Integer p,  String dateInicio, String estado_relacion) {
		log.info("user:detalleOC");
		//UserDTO principal = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("user:allUsers Usuario Actual "+principal.getUsername());
		Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
 		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		
		String starttime = dateInicio != null?dateInicio+" 00:00:00":null;
		String starttime2 = dateInicio != null?dateInicio+" 23:59:59":null;
		//String starttime2 = DateUtils.turnDate4(dateInicio) != null?DateUtils.turnDate4(dateInicio):DateUtils.turnDate4(iFechaFin);
		int total;
		log.info("p:"+p);
		log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado_relacion="+estado_relacion);
		log.info("starttime="+starttime);
		log.info("starttime2="+starttime2);
		log.info("home:iFechaFin="+iFechaFin);
		log.info("home:fecha="+fecha);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);
		log.info("home:starttime2="+ starttime2);
		
		total = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdePaginador(starttime,starttime2, "1");
		log.info("total:"+total);
		
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
	
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		
		
		if (estado_relacion != null )
			qstr += "&estado_relacion="+estado_relacion;
		else
			qstr += "";
		
		
		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleOcEom", qstr);
		
		log.info("Start:"+pageNate.getStart());
		log.info("End:"+pageNate.getLimit());
		
		//List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "1", pageNate.getStart(), pageNate.getLimit());
		List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "1", 0, 1000000000);
		List<HorarioActualizacionStockDTO> horarios = horarioActualizacionStockServicesImpl.getHorarioActualizacionStocks(0, 1);

		int cantidad = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime,starttime2, "1");

		log.info("home:detalles="+ detalles);
		log.info("cantidad="+ cantidad);
		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantidad", cantidad);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("horarios", horarios);//
		model.put("namePage", "ventaEnVerde");//
		return new ModelAndView("role/financial/detalleOcEom", model);
    }
    
    
    @RequestMapping(value = "**/financial/detalleOcEncontrado", method = RequestMethod.GET)
    public ModelAndView detalleOcEncontrado(Integer p, String posted, String dateInicio, String estado_relacion) {
		log.info("user:detalleOcEncontrado");
		//UserDTO principal = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("user:allUsers Usuario Actual "+principal.getUsername());
		log.info("user:posted="+posted);
		log.info("user:dateInicio="+dateInicio);
		log.info("user:estado_relacion="+ estado_relacion);
		
		//Date dNow = new Date();
		//SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		//String currentDate = ft.format(dNow);
		
		Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
 		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		
		String starttime = dateInicio != null?dateInicio+" 00:00:00":null;
		String starttime2 = dateInicio != null?dateInicio+" 23:59:59":null;
		//String starttime2 = DateUtils.turnDate4(dateInicio) != null?DateUtils.turnDate4(dateInicio):DateUtils.turnDate4(iFechaFin);
		int total;
		log.info("p:"+p);
		log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado_relacion="+estado_relacion);
		log.info("starttime="+starttime);
		log.info("starttime2="+starttime2);
		log.info("home:iFechaFin="+iFechaFin);
		log.info("home:fecha="+fecha);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);
		log.info("home:starttime2="+ starttime2);
		
		total = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdePaginador(starttime,starttime2, "2");
		log.info("total:"+total);
		
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
	
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		
		
		if (estado_relacion != null )
			qstr += "&estado_relacion="+estado_relacion;
		else
			qstr += "";
		
		
		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleOcEncontrado", qstr);
		
		log.info("Start:"+pageNate.getStart());
		log.info("End:"+pageNate.getLimit());

		//Oc Encontrado
		//List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "2", pageNate.getStart(), pageNate.getLimit()); 
		List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "2", 0, 1000000000); 
		List<HorarioActualizacionStockDTO> horarios = horarioActualizacionStockServicesImpl.getHorarioActualizacionStocks(0, 1);
		
		
		int cantidad = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime,starttime2, "2");

		log.info("home:detalles="+ detalles);
		log.info("cantidad="+ cantidad);
		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantidad", cantidad);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("horarios", horarios);//
		model.put("namePage", "ventaEnVerde");//
		return new ModelAndView("role/financial/detalleOcEncontrado", model);
    }
    
    
    @RequestMapping(value = "**/financial/detalleOcNoEncontrado", method = RequestMethod.GET)
    public ModelAndView detalleOcNoEncontrado(Integer p, String posted, String dateInicio, String estado_relacion) {
		log.info("user:detalleOcNoEncontrado");
		//UserDTO principal = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("user:allUsers Usuario Actual "+principal.getUsername());
		log.info("user:posted="+posted);
		log.info("user:dateInicio="+dateInicio);
		log.info("user:estado_relacion="+ estado_relacion);
		
		//Date dNow = new Date();
		//SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		//String currentDate = ft.format(dNow);
		
		Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
 		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		
		String starttime = dateInicio != null?dateInicio+" 00:00:00":null;
		String starttime2 = dateInicio != null?dateInicio+" 23:59:59":null;
		//String starttime2 = DateUtils.turnDate4(dateInicio) != null?DateUtils.turnDate4(dateInicio):DateUtils.turnDate4(iFechaFin);
		int total;
		log.info("p:"+p);
		log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado_relacion="+estado_relacion);
		log.info("starttime="+starttime);
		log.info("starttime2="+starttime2);
		log.info("home:iFechaFin="+iFechaFin);
		log.info("home:fecha="+fecha);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);
		log.info("home:starttime2="+ starttime2);
		
		total = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdePaginador(starttime,starttime2, "3");
		log.info("total:"+total);
		
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
	
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		
		
		if (estado_relacion != null )
			qstr += "&estado_relacion="+estado_relacion;
		else
			qstr += "";
		
		
		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleOcNoEncontrado", qstr);
		
		log.info("Start:"+pageNate.getStart());
		log.info("End:"+pageNate.getLimit());

		//Oc No Encontrado
		//List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "3", pageNate.getStart(), pageNate.getLimit()); 
		List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "3", 0, 1000000000); 
		List<HorarioActualizacionStockDTO> horarios = horarioActualizacionStockServicesImpl.getHorarioActualizacionStocks(0, 1);
		
		
		int cantidad = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime,starttime2, "3");

		log.info("home:detalles="+ detalles);
		log.info("cantidad="+ cantidad);
		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantidad", cantidad);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("horarios", horarios);//
		model.put("namePage", "ventaEnVerde");//
		return new ModelAndView("role/financial/detalleOcNoEncontrado", model);
    }
    
    @RequestMapping(value = "**/financial/detalleOcConError", method = RequestMethod.GET)
    public ModelAndView detalleOcConError(Integer p, String posted, String dateInicio, String estado_relacion) {
		log.info("user:detalleOcConError");
		//UserDTO principal = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("user:allUsers Usuario Actual "+principal.getUsername());
		log.info("user:posted="+posted);
		log.info("user:dateInicio="+dateInicio);
		log.info("user:estado_relacion="+ estado_relacion);
		
		//Date dNow = new Date();
		//SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		//String currentDate = ft.format(dNow);
		
		Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
 		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		
		String starttime = dateInicio != null?dateInicio+" 00:00:00":null;
		String starttime2 = dateInicio != null?dateInicio+" 23:59:59":null;
		//String starttime2 = DateUtils.turnDate4(dateInicio) != null?DateUtils.turnDate4(dateInicio):DateUtils.turnDate4(iFechaFin);
		int total;
		log.info("p:"+p);
		log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado_relacion="+estado_relacion);
		log.info("starttime="+starttime);
		log.info("starttime2="+starttime2);
		log.info("home:iFechaFin="+iFechaFin);
		log.info("home:fecha="+fecha);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);
		log.info("home:starttime2="+ starttime2);
		
		total = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdePaginador(starttime,starttime2, "4");
		log.info("total:"+total);
		
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
	
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		
		
		if (estado_relacion != null )
			qstr += "&estado_relacion="+estado_relacion;
		else
			qstr += "";
		
		
		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleOcConError", qstr);
		
		log.info("Start:"+pageNate.getStart());
		log.info("End:"+pageNate.getLimit());

		//Oc No Encontrado
		//List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "4", pageNate.getStart(), pageNate.getLimit()); 
		List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "4", 0, 1000000000); 
		List<HorarioActualizacionStockDTO> horarios = horarioActualizacionStockServicesImpl.getHorarioActualizacionStocks(0, 1);
		
		
		int cantidad = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime,starttime2, "4");

		log.info("home:detalles="+ detalles);
		log.info("cantidad="+ cantidad);
		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantidad", cantidad);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("horarios", horarios);//
		model.put("namePage", "ventaEnVerde");//
		return new ModelAndView("role/financial/detalleOcConError", model);
    }
    
    @RequestMapping(value = "**/financial/detalleCantidaOc", method = RequestMethod.GET)
    public ModelAndView detalleCantidaOc(Integer p, String posted, String dateInicio, String estado_relacion) {
		log.info("user:detalleCantidaOc");
		//UserDTO principal = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//log.info("user:allUsers Usuario Actual "+principal.getUsername());
		log.info("user:posted="+posted);
		log.info("user:dateInicio="+dateInicio);
		log.info("user:estado_relacion="+ estado_relacion);
		
		//Date dNow = new Date();
		//SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		//String currentDate = ft.format(dNow);
		
		Date now = new Date();
 		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
 		String iFechaFin = ft.format(now);
		String fecha = ft.format(now);
		
		String starttime = dateInicio != null?dateInicio+" 00:00:00":null;
		String starttime2 = dateInicio != null?dateInicio+" 23:59:59":null;
		//String starttime2 = DateUtils.turnDate4(dateInicio) != null?DateUtils.turnDate4(dateInicio):DateUtils.turnDate4(iFechaFin);
		int total;
		log.info("p:"+p);
		log.info("home:dateInicio="+dateInicio);
 		log.info("home:estado_relacion="+estado_relacion);
		log.info("starttime="+starttime);
		log.info("starttime2="+starttime2);
		log.info("home:iFechaFin="+iFechaFin);
		log.info("home:fecha="+fecha);
		log.info("home:dateInicio="+ dateInicio);
		log.info("home:starttime="+ starttime);
		log.info("home:starttime2="+ starttime2);
		log.info("home:starttime2="+ starttime2);
		
		total = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdePaginador(starttime,starttime2, "5");
		log.info("total:"+total);
		
		int pagelimit1 = 0;
		int pagelimit = pagelimit1 > 0?pagelimit1:25;
		int p1 = p != null?p:1;
		String qstr = "";
	
		
		if (dateInicio != null)
			qstr += "&dateInicio="+DateUtils.encode(dateInicio);
		else
			qstr += "";
		
		
		
		if (estado_relacion != null )
			qstr += "&estado_relacion="+estado_relacion;
		else
			qstr += "";
		
		
		
		log.info("qstr:"+qstr);
		PageNate pageNate = new PageNate(total, p1, pagelimit, "");
		pageNate.setURL("detalleCantidaOc", qstr);
		
		log.info("Start:"+pageNate.getStart());
		log.info("End:"+pageNate.getLimit());

		//Oc No Encontrado
		//List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "5", pageNate.getStart(), pageNate.getLimit()); 
		List<CuadraturaVentaVerdeDTO> detalles = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerde(starttime,starttime2, "5", 0, 1000000000); 
		List<HorarioActualizacionStockDTO> horarios = horarioActualizacionStockServicesImpl.getHorarioActualizacionStocks(0, 1);

		int cantidad = cuadraturaVentaVerdeServicesImpl.getCuadraturaVentaVerdeContar(starttime,starttime2, "5");

		log.info("home:detalles="+ detalles);
		log.info("cantidad="+ cantidad);
		
 		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cantidad", cantidad);//
		model.put("detalles", detalles);//
		model.put("fecha", DateUtils.turnDate5(starttime));//
		model.put("record", total);
		model.put("p", p);
		model.put("numpages", pageNate.getNumPages());
		model.put("pagelinks", pageNate.getPageLinks());
		model.put("horarios", horarios);//
		model.put("namePage", "ventaEnVerde");//
		return new ModelAndView("role/financial/detalleCantidaOc", model);
    }
    
    
    
    
 
     

}
