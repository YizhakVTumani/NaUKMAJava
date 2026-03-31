package practice10;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;



public class Event {
    static String title;
    long start;
    double durationMinute;
    String zone;
    LocalDate date;
    static String track;

    static LocalDate end(){
        return LocalDate.now();
    }

    public Event(String title, String track, LocalDate date){
        this.title = title;
        this.track = track;
        this.date = date;
    }

    static Event label(String tr, String tit){
        title = tit;
        track = tr;
        Event e = new Event(tit, tr, end());
        System.out.println("time: " + end() + "title: " + title + "track: " + track);
        return e;
    }

    public class LambdaRefactorLab {

        public static void sortAnonymous(List<Event> events) {
            events.sort(new Comparator<Event>() {
                @Override
                public int compare(Event e1, Event e2) {
                    return e1.end().compareTo(e2.end());
                }
            });
        }

        public static void sortLambda(List<Event> events) {
            events.sort((e1, e2) -> e1.end().compareTo(e2.end()));
        }

        public static void sortMethodRef(List<Event> events) {
            events.sort(Comparator.comparing(event -> event.end()));

        }
    }

}

class Main{
    static void main() {
        List<Event> list = new ArrayList<>();
        Event e1 = Event.label("track", "title");
        list.add(e1);
        Event e2 = Event.label("track1", "title");
        list.add(e2);
        Event e3 = Event.label("track2", "title");
        list.add(e3);
        Event e4 = Event.label("track3", "title");
        list.add(e4);
        System.out.println(list);


        Predicate<Event> titleSearchNull = event -> event.title == null;
        Function<Event, String> toLabel =
                event -> "Ev#" + Event.title + " track=" + Event.track;
//        List<String> labels = EventManager.map(list, toLabel);
        Consumer<Event> audit = event -> System.out.println("All users were notif: " + event.title);
        String msg = EventManager.debug(() -> "Debug is enabled: ");
        EventManager.pick(list, titleSearchNull);
        EventManager.map(list, toLabel);
        EventManager.notifyAll(list, audit);
        System.out.println(msg);

        Predicate<Event> filter = e -> e.title == "title" || e.title == "notTitle";
        Predicate<Event> morning = event -> event.end().isAfter(ChronoLocalDate.from(LocalDateTime.of(2025, 12, 05, 12, 0)));
        EventManager.findConflict(list);
    }
}

class EventManager{

    static void pick(List<Event> list, Predicate<Event> predicate){
        List <Event> res = new ArrayList<>();
        for (Event event : list){
            if(predicate.test(event)){
                res.add(event);
            }
        }
        System.out.println(res);
    }

    static List<String> map(List <Event> list, Function <Event, String> func){
        List <String> res = new ArrayList<>();
        for (Event e : list){
            res.add(func.apply(e));
        }
        System.out.println(res);
        return res;
    }

    static void notifyAll (List <Event> list, Consumer <Event> cons){
        for (Event e : list){
            cons.accept(e);
        }
    }

    static String debug (Supplier<String> msg){
        boolean debugEnabled = true;
        return debugEnabled ? msg.get() + "true" : "";
    }

    static void findConflict (List<Event> events){
        BiPredicate<Event, Event> isOverlapping = (e1, e2) ->
                e1.title == e2.title;

        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event e1 = events.get(i);
                Event e2 = events.get(j);

                if (isOverlapping.test(e1, e2)) {
                    System.out.println(e1 + " conf: " + e2);
                }
            }
        }
    }
}


//class DateTimeLab{
//    public static Instant toInstant(Event e) {
//        return e.end()
////                .atZone(ZoneId.systemDefault())
////                .toInstant();
//    }
//
//
//}


