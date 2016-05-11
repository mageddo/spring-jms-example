package hello.rest;

import hello.jms.ping.PingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 5/11/16 6:59 PM
 */
@Controller
public class PingRest {

    @Autowired
    private PingProducer pingProducer;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public String ping(@RequestParam(name = "who", defaultValue = "Anonymous") final String who) {
        pingProducer.doPing(who);
        return "the ping was sent, wait for the receiver";
    }
}
