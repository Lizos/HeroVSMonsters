package com.Lisa.monsters;

import java.util.ArrayList;

public class Log {
    //TODO rewrite with events
    public enum RecordType {
        ATTACK, BLOCK, SPEECH, INFO, SYS_MESSAGE
    }

    public class Record {
        public int id;//counter
        public RecordType record_type;//attack/block/speech
        public String unit_A;//character that act
        public String unit_B;//character that get act
        public int amount;//damage or heal
        public String text;//description

    }

    private ArrayList<Record> _messages;
    private static Log _instance;

    private Log() {
        _messages = new ArrayList<>();
    }


    public static Log getInstance() {
        if (_instance == null) {
            _instance = new Log();
        }
        return _instance;
    }


    public void input(RecordType recordType, String unitA, String unitB, int amount, String text) {
        Record record = new Record();
        record.record_type = recordType;
        record.unit_A = unitA;
        record.unit_B = unitB;
        record.amount = amount;
        record.text = text;
        _messages.add(record);
    }

    public void showRecords() { // for test only
        _messages.forEach((n) -> System.out.println("id:"+n.id +"|"+ n.record_type +"|"+ n.unit_A +"|"+ n.unit_B +"|"+ n.amount +"|"+ n.text ));
    }


    public ArrayList<Record> output() {
        return _messages;
    }
}
