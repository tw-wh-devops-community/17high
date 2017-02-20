package com.tw.wh.devops.web.controller;

import com.tw.wh.devops.domains.Activity;
import com.tw.wh.devops.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xjzhou on 2/15/17.
 */
@RestController
@RequestMapping("/activities")
public class ActivitiesController {

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(method = RequestMethod.GET)

    public Iterable getActivities(@RequestParam(defaultValue = "${17high.page.size}") int size,
                              @RequestParam(defaultValue = "${17high.page.number}") int page,
                              @RequestParam(required = false, defaultValue="") String type,
                              @RequestParam(required = false, defaultValue="") String status,
                              @RequestParam(required = false, defaultValue="") String sortBy,
                              @RequestParam(required = false, defaultValue="") String sortOrder,
                              HttpServletRequest request,
                              HttpServletResponse response) {

        Iterable<Activity> activities = activityRepository.findAll();
        return activities;
    }

    @SuppressWarnings("unused")
    public void setActivityRepository(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
}
