package com.tw.wh.devops.rest.controller;

import com.tw.wh.devops.domains.Activity;
import com.tw.wh.devops.repositories.ActivityRepository;
import com.tw.wh.devops.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by xjzhou on 2/15/17.
 */
@RestController
@RequestMapping("/v1/activities")
public class ActivitiesController {

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(method = GET)
    public Iterable getActivities(@RequestParam(defaultValue = "${17high.page.size}") int size,
                                  @RequestParam(defaultValue = "${17high.page.number}") int page,
                                  @RequestParam(required = false, defaultValue = "") String type,
                                  @RequestParam(required = false, defaultValue = "") String status,
                                  @RequestParam(required = false, defaultValue = "") String sortBy,
                                  @RequestParam(required = false, defaultValue = "") String sortOrder,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        Iterable<Activity> activities = activityRepository.findAll();
        return activities;
    }

    @RequestMapping(path = "/{id}", method = GET)
    public @ResponseBody Activity getActivity(@PathVariable(value = "id") long id) {
        Activity activity = activityRepository.findOne(id);
        if (null == activity) {
            throw new ResourceNotFoundException("Activity can not be found.");
        }
        return activity;
    }

    @SuppressWarnings("unused")
    public void setActivityRepository(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
}
