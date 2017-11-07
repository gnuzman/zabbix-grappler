package com.zzh.zabbix.grappler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.List;

@RestController
public class GrapplerController {

    @PostMapping("zabbix")
    public Object zabbix(@RequestBody List<String> lstMetric) throws Exception {
        InetAddress agentAddress = InetAddress.getByName("192.168.42.32");
        PassiveAgentClient agentClient = new PassiveAgentClient(agentAddress, 10050);

        return agentClient.getValues(lstMetric);
    }
}
