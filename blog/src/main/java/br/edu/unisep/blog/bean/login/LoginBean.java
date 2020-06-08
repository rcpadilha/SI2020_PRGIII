package br.edu.unisep.blog.bean.login;

import br.edu.unisep.blog.dto.login.LoginDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LoginBean {

    @Getter @Setter
    private LoginDto loginData = new LoginDto();

    @Inject
    private ExternalContext context;

    public String login() {
        var request = (HttpServletRequest) context.getRequest();

        try {
            // Converte a senha informada pelo usuário na tela em MD5
            var password = DigestUtils.md5Hex(loginData.getPassword());

            // Executa a autenticação de login na requisição
            request.login(loginData.getLogin(), password);

        } catch(Exception e) {
            e.printStackTrace();
            return "index.xhtml";
        }

        return "app/home.xhtml?faces-redirect=true";
    }

}
