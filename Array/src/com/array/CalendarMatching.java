package com.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarMatching {

    static class StringMeeting {
        public String start;
        public String end;
        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Meeting {
        public int start;
        public int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<StringMeeting> calendarMatching(
        List<StringMeeting> calendar1,
        StringMeeting dailyBounds1,
        List<StringMeeting> calendar2,
        StringMeeting dailyBounds2,
        int meetingDuration) {

        // update the calenders with the daily bounds
        updateCalenderBounds(calendar1, dailyBounds1);
        updateCalenderBounds(calendar2, dailyBounds2);

        // convert the time to mins
        List<Meeting> meetings1 = convertTimeToMinutes(calendar1);
        List<Meeting> meetings2 = convertTimeToMinutes(calendar2);

        // merge the calenders according to the times
        List<Meeting> mergedMeetings = mergeMeetings(meetings1, meetings2);

        // flatten the calenders by comparing the end and start time
        List<Meeting> flattenMeeting = flattenMeeting(mergedMeetings);

        // find the time diff and return the calender
        List<StringMeeting> availableMeetings = findAvailableTimeSlots(flattenMeeting, meetingDuration);

        return availableMeetings;
    }

    private static void updateCalenderBounds(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        StringMeeting morning = new StringMeeting("0:00", dailyBounds.start);
        StringMeeting evening = new StringMeeting(dailyBounds.end, "23:59");
        calendar.add(0, morning);
        calendar.add(evening);
    }

    private static List<Meeting> mergeMeetings(List<Meeting> meetings1, List<Meeting> meetings2) {
        List<Meeting> mergedMeetings = new ArrayList<>();
        int i = 0, j = 0;
        while(i < meetings1.size() && j < meetings2.size()) {
            if(meetings1.get(i).start <= meetings2.get(j).start) {
                mergedMeetings.add(meetings1.get(i));
                i++;
            } else {
                mergedMeetings.add(meetings2.get(j));
                j++;
            }
        }
        while(i < meetings1.size()) {
            mergedMeetings.add(meetings1.get(i));
            i++;
        }
        while(j < meetings2.size()) {
            mergedMeetings.add(meetings2.get(j));
            j++;
        }
        return mergedMeetings;
    }

    private static List<Meeting> flattenMeeting(List<Meeting> mergedMeetings) {
        int cursor = 1;
        while(cursor < mergedMeetings.size()) {
            Meeting prev = mergedMeetings.get(cursor-1);
            Meeting curr = mergedMeetings.get(cursor);
            if(prev.end >= curr.start) {
                mergedMeetings.remove(cursor);
                mergedMeetings.remove(cursor-1);
                mergedMeetings.add(cursor-1, new Meeting(prev.start, Math.max(prev.end, curr.end)));
            } else {
                // flattenedMeeting.add(new Meeting(prev.start, prev.end));
                cursor++;
            }
        }
        return mergedMeetings;
    }

    private static int timeInStringToMins(String timeInString) {
        String[] arr = timeInString.split(":");
        return (Integer.valueOf(arr[0]) * 60) + Integer.valueOf(arr[1]);
    }

    private static List<Meeting> convertTimeToMinutes(List<StringMeeting> calendar1) {
        return calendar1
                .stream()
                .map(meeting -> {
                    return new Meeting(timeInStringToMins(meeting.start), timeInStringToMins(meeting.end));
                })
                .collect(Collectors.toList());
    }

    private static String timeInMinsToString(int time) {
        int hours = time / 60;
        int mins = time % 60;
        String hourString = Integer.toString(hours);
        String minuteString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toString(mins);
        return hourString + ":" + minuteString;
    }

    private static List<StringMeeting> findAvailableTimeSlots(List<Meeting> flattenMeeting, int meetingDuration) {
        List<StringMeeting> availableMeetings = new ArrayList<>();
        for(int i = 1; i < flattenMeeting.size(); i++) {
            Meeting m1 = flattenMeeting.get(i-1);
            Meeting m2 = flattenMeeting.get(i);
            if((m2.start - m1.end) >= meetingDuration) {
                availableMeetings.add(new StringMeeting(timeInMinsToString(m1.end), timeInMinsToString(m2.start)));
            }
        }
        return availableMeetings;
    }

    public static void main(String[] args) {
        List<StringMeeting> calender1 = new ArrayList<>();
        calender1.add(new StringMeeting("9:00", "10:30"));
        calender1.add(new StringMeeting("12:00", "13:00"));
        calender1.add(new StringMeeting("16:00", "18:00"));

        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");

        List<StringMeeting> calender2 = new ArrayList<>();
        calender2.add(new StringMeeting("10:00", "11:30"));
        calender2.add(new StringMeeting("12:30", "14:30"));
        calender2.add(new StringMeeting("14:30", "15:00"));
        calender2.add(new StringMeeting("16:00", "17:00"));

        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");

        int meetingDuration = 30;

        List<StringMeeting> result = CalendarMatching.calendarMatching(calender1, dailyBounds1, calender2, dailyBounds2, meetingDuration);
        result.stream().forEach(meeting -> {
            System.out.println(meeting.start + "-" + meeting.end);
        });
    }


}
