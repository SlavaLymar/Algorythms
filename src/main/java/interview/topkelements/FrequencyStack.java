package interview.topkelements;

import java.util.*;

public class FrequencyStack {

    // push(1), push(2), push(3), push(2), push(1), push(2), push(5)
    // {number, frequency, sequenceNum} - element
    // 7 - seq
    // [ {1,2}, {2,3}, {3,1}, {5,1} ] - map<num,freq>
    // [ {2,3,5}, {1,2,4}, {2,2,3}, {5,1,6}, {3,1,2}, {2,1,1}, {1,1,0} ] - priorityQueue<element>
    // pop() => 2
    // [ {1,2,4}, {2,2,3}, {5,1,6}, {3,1,2}, {2,1,1}, {1,1,0} ]
    // pop() => 1
    // [ {2,2,3}, {5,1,6}, {3,1,2}, {2,1,1}, {1,1,0} ]
    // pop() => 2
    //
    // t: O (N + Log N)
    // space: O (N)
    //
    class Element {
        int number;
        int frequency;
        int sequenceNum;

        Element(int number, int frequency, int sequenceNum) {
            this.number = number;
            this.frequency = frequency;
            this.sequenceNum = sequenceNum;
        }
    }

    class ElementComparator implements Comparator<Element> {
        public int compare(Element e1, Element e2) {
            if (e1.frequency != e2.frequency) {
                return e2.frequency - e1.frequency;
            } else {
                return e2.sequenceNum - e1.sequenceNum;
            }
        }
    }

    private int sequenceNum = 0;
    private Map<Integer, Integer> numFrequency = new HashMap<>();
    private Queue<Element> maxHeap = new PriorityQueue<>(new ElementComparator());

    public void push(int num) {
        this.numFrequency.put(num, this.numFrequency.getOrDefault(num, 0) + 1);
        this.maxHeap.add(new Element(num, this.numFrequency.get(num), this.sequenceNum++));
    }

    public int pop() {
        if (!this.maxHeap.isEmpty()) {
            Element element = this.maxHeap.poll();
            int frequency = this.numFrequency.get(element.number);
            if (frequency > 1) {
                this.numFrequency.put(element.number, frequency - 1);
            } else {
                this.numFrequency.remove(element.number);
            }
            return element.number;
        } else {
            throw new RuntimeException("No more nums!");
        }
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
