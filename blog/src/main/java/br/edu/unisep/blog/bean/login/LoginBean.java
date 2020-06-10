package br.edu.unisep.blog.bean.login;

import br.edu.unisep.blog.bean.user.UserBean;
import br.edu.unisep.blog.dto.login.LoginDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Named
@RequestScoped
public class LoginBean {

    @Getter
    @Setter
    private LoginDto loginData = new LoginDto();

    @Inject
    private ExternalContext context;

    @Inject
    private UserBean userBean;

    public String login() {
        var request = (HttpServletRequest) context.getRequest();

        try {
            // Realiza logout da sessão
            request.logout();

            // Converte a senha informada pelo usuário na tela em MD5
            var password = DigestUtils.md5Hex(loginData.getPassword());

            // Executa a autenticação de login na requisição
            request.login(loginData.getLogin(), password);

            // Carrega os dados do usuário logado no bean de sessão.
            userBean.loadUser(loginData.getLogin());

        } catch (Exception e) {
            e.printStackTrace();
            return "index.xhtml";
        }

        return "app/home.xhtml?faces-redirect=true";
    }

    public String logout() {
        try {
            var request = (HttpServletRequest) context.getRequest();
            request.logout();
            userBean.clearUser();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return "/index.xhtml?faces-redirect=true";
    }

    public void checkLogin(){
        try {
            if (userBean.getUser() != null) {
                context.redirect("app/home.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}