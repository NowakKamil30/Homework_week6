package pl.akademiaspringa.homeworkweek6.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.akademiaspringa.homeworkweek6.Models.Movie;
import pl.akademiaspringa.homeworkweek6.services.EmailService;

import javax.mail.MessagingException;

@Aspect
@Component
public class EmailAspect {

    private final EmailService emailService;
    private final TemplateEngine templateEngine;

    public EmailAspect(EmailService emailService, TemplateEngine templateEngine) {
        this.emailService = emailService;
        this.templateEngine = templateEngine;
    }

    @After("@annotation(SendEmail)")
    public void sendEmail(JoinPoint joinPoint) {
        if (joinPoint.getArgs()[0] instanceof Movie) {
            Movie movie = (Movie) joinPoint.getArgs()[0];
            System.out.println(movie);
            Context context = new Context();
            context.setVariable("hello",
                    "Hello " + movie.getUser().getFirstName() + " " + movie.getUser().getLastName());
            context.setVariable("message", "Thank you so much! We added your movie to our list");
            String body = templateEngine.process("addMovie", context);
            try {
                emailService.sendMail(movie.getUser().getEmail(), "Film dodano",body);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

}
