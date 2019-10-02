/**
 * Copyright (c) 2014, Deem Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.deem.zkui;

import com.deem.zkui.dao.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;


import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main extends SpringBootServletInitializer {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    public static void main(String[] args) {
        logger.debug("Starting ZKUI!");
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Properties globalProps() throws Exception {
        Properties globalProps = new Properties();
        File f = new File("config.cfg");
        if (f.exists()) {
            globalProps.load(new FileInputStream("config.cfg"));
        } else {
            System.out.println("Please create config.cfg properties file and then execute the program!");
            System.exit(1);
        }

        globalProps.setProperty("uptime", new Date().toString());
        return globalProps;
    }

}
