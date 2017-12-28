
/**
 *@name HomeController.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.web.controller.home;

import java.security.Principal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencosud.mobile.core.ClienteRetiraServices;
import com.cencosud.mobile.core.CuadraturaVentaVerdeServices;
import com.cencosud.mobile.core.CumplimientokpiWebServices;
import com.cencosud.mobile.core.DescripcionEmpresaServices;
import com.cencosud.mobile.core.EcommerceSoporteVentaServices;
import com.cencosud.mobile.core.EstadoCumpleResumenServices;
import com.cencosud.mobile.core.EstadoCumpleServices;
import com.cencosud.mobile.core.EstadoCumplimientoServices;
import com.cencosud.mobile.core.EstadoResponsableServices;
import com.cencosud.mobile.core.HorarioActualizacionStockServices;
import com.cencosud.mobile.core.HorarioServices;
import com.cencosud.mobile.core.HorarioVentaEnVerdeActualizacionServices;
import com.cencosud.mobile.core.TipoEstadoVentaEnVerdeServices;
import com.cencosud.mobile.core.TipoGuiaServices;
import com.cencosud.mobile.core.TipoOrdenServices;
import com.cencosud.mobile.core.TipoVentaServices;
import com.cencosud.mobile.core.UserServices;
import com.cencosud.mobile.core.VentaEmpresaServices;
import com.cencosud.mobile.core.util.PageNate;
import com.cencosud.mobile.dto.users.ClienteRetiraDTO;
import com.cencosud.mobile.dto.users.CuadraturaVentaVerdeDTO;
import com.cencosud.mobile.dto.users.DescripcionEmpresaDTO;
import com.cencosud.mobile.dto.users.EcommerceSoporteVentaDTO;
import com.cencosud.mobile.dto.users.EstadoCumpleDTO;
import com.cencosud.mobile.dto.users.EstadoCumpleResumenDTO;
import com.cencosud.mobile.dto.users.EstadoCumplimientoDTO;
import com.cencosud.mobile.dto.users.EstadoResponsableDTO;
import com.cencosud.mobile.dto.users.HorarioActualizacionStockDTO;
import com.cencosud.mobile.dto.users.HorarioDTO;
import com.cencosud.mobile.dto.users.RoleDTO;
import com.cencosud.mobile.dto.users.TipoGuiaDTO;
import com.cencosud.mobile.dto.users.TipoOrdenDTO;
import com.cencosud.mobile.dto.users.TipoVentaDTO;
import com.cencosud.mobile.dto.users.UserDTO;
import com.cencosud.mobile.dto.users.VentaEmpresaDTO;
import com.cencosud.mobile.web.utils.DateUtils;
import com.cencosud.mobile.web.utils.StringUtils;
/**
 * @description Clase controladora que direcciona a un rol de usuario 
 */
@Controller
public class HomeController /* extends BaseController*/{
	
    private static Logger log = Logger.getLogger(HomeController.class);
    
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
    
    
   
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
		log.info("index:inicio");
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView forward = null;

		if(a.getPrincipal() instanceof UserDTO ){
			UserDTO current = (UserDTO) a.getPrincipal();
			
			if(current!=null){
				List<RoleDTO> roles = current.getRoles();
				for (int i = 0; i < roles.size(); i++) {
					RoleDTO rol = roles.get(i);
					if (rol.getRole().equals("ROLE_ADMIN")) {
			        	forward = new ModelAndView("/role/admin/home", model);
			        	break;
			        }else{
			            if (rol.getRole().equals("ROLE_USER_IF")) {
			            	forward = new ModelAndView("/role/financial/home", model);
			                 break;
			            }else{
			            	 if (rol.getRole().equals("ROLE_COMMERCE")) {
			            		 forward = new ModelAndView("/role/commerce/home", model);
			                    break;
			                 }
			            }
			        }
				}
			}
			
			if(forward == null){
				forward = new ModelAndView("/login/sign-in", model);
			}
		}else{
			forward = new ModelAndView("login/sign-in", model);
		}
		
		return forward;
    }
    
    @RequestMapping(value = "**/admin/home", method = RequestMethod.GET)
    public ModelAndView homeAdmin(ModelMap model, Principal principal) {
		log.info("homeAdmin:inicio");
		UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return new ModelAndView("role/admin/home", model);
    }
    
    @RequestMapping(value = "**/commerce/home", method = RequestMethod.GET)
    public ModelAndView homeCommerce(ModelMap model, Principal principal) {
		log.info("homeCommerce:inicio");
		UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return new ModelAndView("role/commerce/home", model);
    }
    
    @RequestMapping(value = "**/financial/home", method = RequestMethod.GET)
    public ModelAndView homeFinancialInstitucion(ModelMap model, Principal principal) {
		log.info("homeFinancialInstitucion:inicio");
		UserDTO user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return new ModelAndView("role/financial/home", model);
    }
    
   
    
   
    
    
}
