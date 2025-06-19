package org.yf.edu.co.Agenda_De_Contactos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yf.edu.co.Agenda_De_Contactos.model.Contacto;
import org.yf.edu.co.Agenda_De_Contactos.repository.IContactoRepository;

import java.util.List;

@Controller
public class ContactoController {

    //Inyectamos el repositorio:
    @Autowired
    private IContactoRepository contactoRepository;

    //Metodo para ver en la pantalla de inicio:
    @GetMapping({"/", ""})
    public String verPaginaInicio(Model model) {
        List<Contacto> contactos = contactoRepository.findAll();
        model.addAttribute("contactos", contactos);
        return "index";
    }

    //Para mostrar el formulario para crear un nuevo contacto:
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistrarContacto(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    //BindingResult: Para pbtener todos lo errores y mostrarlos en el frontEnd:
    @PostMapping("/nuevo")
    public String guardarContacto(@Validated Contacto contacto,BindingResult bindingResult ,RedirectAttributes redirectAttributes, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("contacto", contacto);//Para mostrar un nuevo formulario
            return "nuevo";
        }

        contactoRepository.save(contacto);
        redirectAttributes.addFlashAttribute("mensaje", "Contacto guardado exitosamente");
        return "redirect:/";
    }


    @GetMapping("/{id}/editar")
    public String mostrarFormularioDeEditarContacto(@PathVariable Integer id, Model model) {
        Contacto contacto = contactoRepository.getById(id);//obtenemos el contacto
        model.addAttribute("contacto", contacto);//Enviamos elcontacto al formulario
        return "nuevo";
    }

    @PostMapping("/{id}/editar")
    public String actualizarContacto(@PathVariable Integer id,@Validated Contacto contacto,
                                     BindingResult bindingResult ,RedirectAttributes redirectAttributes, Model model) {

        Contacto contactoBd = contactoRepository.getById(id);//obtenemos el contacto

        if(bindingResult.hasErrors()) {
            model.addAttribute("contacto", contacto);//Para crear un nuevo formulario
            return "nuevo";//documento html
        }

        contactoBd.setNombre(contacto.getNombre());
        contactoBd.setCelular(contacto.getCelular());
        contactoBd.setEmail(contacto.getEmail());
        contactoBd.setFechaNacimeinto(contacto.getFechaNacimeinto());

        contactoRepository.save(contactoBd);
        redirectAttributes.addFlashAttribute("mensaje", "Contacto ha sido actualizado exitosamente");
        return "redirect:/";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarContacto(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Contacto contacto = contactoRepository.getById(id);//obtenemos el contacto
        contactoRepository.delete(contacto);//eliminamos el contacto
        redirectAttributes.addFlashAttribute("mensaje", "Contacto ha sido eliminado exitosamente");
        return "redirect:/";
    }

}
