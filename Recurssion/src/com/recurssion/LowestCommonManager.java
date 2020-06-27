package com.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowestCommonManager {

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        return getLowestCommonManagerr(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    public static OrgInfo getLowestCommonManagerr(
            OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numOfReports = 0;
        for(OrgChart reporter : manager.directReports) {
            OrgInfo childOrgfInfo = getLowestCommonManagerr(reporter, reportOne, reportTwo);
            if(childOrgfInfo.lowestCommonManager != null && childOrgfInfo.numOfRequiredReporters == 2) {
                return childOrgfInfo;
            }
            numOfReports += childOrgfInfo.numOfRequiredReporters;
        }

        if(manager.name == reportOne.name || manager.name == reportTwo.name) {
            numOfReports += 1;
        }

        return new OrgInfo((numOfReports) == 2 ? manager : null, numOfReports);
    }

    static class OrgInfo {
        public OrgChart lowestCommonManager;
        public int numOfRequiredReporters;

        public OrgInfo(OrgChart lowestCommonManager, int numOfRequiredReporters) {
            this.lowestCommonManager = lowestCommonManager;
            this.numOfRequiredReporters = numOfRequiredReporters;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    public static void main(String[] args) {
        OrgChart o1 = new OrgChart('A');
        OrgChart o2 = new OrgChart('B');
        OrgChart o3 = new OrgChart('C');
        OrgChart o4 = new OrgChart('D');
        OrgChart o5 = new OrgChart('E');
        OrgChart o6 = new OrgChart('F');
        OrgChart o7 = new OrgChart('G');

        o2.addDirectReports(new OrgChart[]{o4, o5});
        o3.addDirectReports(new OrgChart[]{o6, o7});
        o1.addDirectReports(new OrgChart[]{o2, o3});

        OrgChart result = LowestCommonManager.getLowestCommonManager(o1, o2, o7);
        System.out.println(result.name);
    }

}
