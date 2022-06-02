package Notes;


import java.util.*;

/*
Code a system that can schedule meetings in a predefined set of conference rooms.
It should have a method like scheduleMeeting(timeRange) which returns any available room at that time and reserves it or an error if no rooms are available.

*/
/*
1  -- [   ----- ]]

List<Intervals> -





*/
// Main class should be named 'Solution'
class UberProduct {
    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler(2);
        List<Interval> testDate = new ArrayList<>();
        testDate.add(new Interval(new Date(2000l),new Date(3000l)));
        testDate.add(new Interval(new Date(1000l),new Date(4000l)));
        testDate.add(new Interval(new Date(0000l),new Date(5000l)));
        for(Interval i:testDate){
            BookingResponse response = scheduler.bookMeetingRoom(i.startTime, i.endTime);
            System.out.println(response.success);
            if(response.success)
            System.out.println("Room: "+ response.meetingInfo.roomInfo);
        }



    }
}


class MeetingScheduler{

    MeetingRoomManager meetingRoomManager;
    public MeetingScheduler(int numberOfRooms){
        meetingRoomManager =new MeetingRoomManager(numberOfRooms);
    }

    BookingResponse bookMeetingRoom(Date startTime,Date endTime){
        BookingResponse response = new BookingResponse();
        for(MeetingRoom meetingroom : meetingRoomManager.getMeetingRooms()){
            response= meetingroom.bookMeeting(startTime, endTime);
            if(response.success){
                return response;
            }
        }
        return response;
    }








}




class MeetingRoomManager{

    List<MeetingRoom> meetingRoomList;

    public MeetingRoomManager(int numberOfRooms){
        meetingRoomList = new ArrayList<>();
        for(int i=0;i<numberOfRooms;i++){
            meetingRoomList.add(new MeetingRoom(String.valueOf(i)));
        }

    }

    public List<MeetingRoom> getMeetingRooms(){
        return this.meetingRoomList;
    }

}

class MeetingRoom {

    String id;

    //List<Interval> bookedSlots;
    Map<Meeting,Interval > bookedMeetings;

    public MeetingRoom(String id){
        this.id = id;
        bookedMeetings = new HashMap<>();
    }

    BookingResponse bookMeeting(Date startTime,Date endTime){
        if(!bookedMeetings.isEmpty()){
          //  System.out.println(" testing for "+ startTime+ " "+ endTime);
            for(Map.Entry<Meeting,Interval> entry : bookedMeetings.entrySet()){
                //System.out.println(entry.getKey().roomInfo + " :: "+ entry.getValue().startTime +" "+ entry.getValue().endTime);
                Interval temp = entry.getValue();
                if(startTime.before(temp.endTime) && endTime.after(temp.startTime))
                    return getFailedResponse();
            }
        }
        return getSuccessResponse(startTime, endTime);
    }

    BookingResponse getFailedResponse(){
        return new BookingResponse(false, null);
    }

    BookingResponse getSuccessResponse(Date startTime,Date endTime){
        Interval interval = new Interval(startTime, endTime);
        Meeting meeting = new Meeting(this.id, interval);
        bookedMeetings.put(meeting, interval);
        return new BookingResponse(true, meeting);
    }

}

class BookingResponse{

    boolean success;
    Meeting meetingInfo;
    public BookingResponse(boolean success, Meeting meetingInfo){
        this.success = success;
        this.meetingInfo = meetingInfo;
    }

    public BookingResponse(){}

}

class Meeting{
    String id;
    String roomInfo;
    Interval interval;

    public Meeting(String roomInfo,Interval interval){
        this.roomInfo  = roomInfo;
        this.interval = interval;
        this.id = UUID.randomUUID().toString();
    }

}



class Interval{

    public Date startTime;
    public Date endTime;

    public Interval(Date startTime,Date endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

}




