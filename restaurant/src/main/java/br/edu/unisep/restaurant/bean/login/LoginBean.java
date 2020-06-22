package br.edu.unisep.restaurant.bean.login;

import br.edu.unisep.restaurant.bean.user.UserBean;
import br.edu.unisep.restaurant.dto.login.LoginDto;
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
            request.logout();

            var password = DigestUtils.md5Hex(loginData.getPassword());
            request.login(loginData.getLogin(), password);
            userBean.loadUser(loginData.getLogin());

            return "app/orders.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "index.xhtml";
        }
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

    public void checkLogin() {
        try {
            if (userBean.getUser() != null) {
                context.redirect("app/orders.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}