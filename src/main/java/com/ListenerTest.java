package com;

import org.testng.*;

import java.sql.SQLOutput;

public class ListenerTest implements ITestListener {
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish");
//        System.out.println("1 :" + context.getName());
//        System.out.println("2 :" + context.getHost());
//        System.out.println("3 :" + context.getOutputDirectory());
        System.out.println("4 :" + context.getEndDate());
        System.out.println("5 :" + context.getStartDate());
        System.out.println("6 :" + context.getSkippedConfigurations());
//        System.out.println("6 :" + context.getSuite());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart");
        System.out.println("1");
        System.out.println(context.getFailedButWithinSuccessPercentageTests());
//        System.out.println("1 :" + context.getName());
//        System.out.println("2 :" + context.getHost());
//        System.out.println("3 :" + context.getOutputDirectory());
//        System.out.println("4 :" + context.getEndDate());
//        System.out.println("5 :" + context.getStartDate());
//        System.out.println("6 :" + context.getSuite());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
        System.out.println(arg0.getStatus());
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        System.out.println(result.getStatus());
        System.out.println(result.getTestName());
//        System.out.println("Fail: please check account " + result.getName());
        DriverUlti.takeShot("/Users/apple/Desktop/hinh_fail.png");
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        System.out.println("onTestSkipped");
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        System.out.println("onTestStart");
        System.out.println(arg0.getStatus());
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
        System.out.println(result.getStatus());
//        System.out.println("ok finnish " + result.getName());
        DriverUlti.takeShot("/Users/apple/Desktop/hinh_loi.png");
    }
}
