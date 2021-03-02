import java.util.ArrayList;

public class ProblemSet11 {

    public static void main(String[] args) {

    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start > end) {
            return null;
        } else {
            int arrayLength = end - start;
            ArrayList<String> stringArray = new ArrayList<>();
            int current = start;
            for (int i = 0; i < arrayLength; i++) {
                if (current % 3 == 0 && current % 5 == 0) {
                    stringArray.add("Fizzbuzz");
                    current++;
                } else if (current % 3 == 0) {
                    stringArray.add("Fizz");
                    current++;
                } else if (current % 5 == 0) {
                    stringArray.add("Buzz");
                    current++;
                } else {
                    stringArray.add((String.valueOf(current)));
                    current++;
                }
            }
            return stringArray;
        }
    }


    public int maxSpan(ArrayList<Integer> numbers) {
        if(numbers == null) {
            return -1;
        }
        else {
            if(numbers.size() == 0) {
                return -1;
            }
            else {
                int span = -1;
                for (int i = 0; i < numbers.size(); i++) {
                    int currentValue = numbers.get(i);
                    for (int j = numbers.size() - 1; j > i; j--) {
                        if (currentValue == numbers.get(j) && j - i > span) {
                            span = j - i + 1;
                        }
                    }
                }
                return span;
            }
        }
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return null;
        }
        else {
            int threeCount = 0;
            int fourCount = 0;
            boolean threeAfterThree = false;
            boolean fourBeforeThree = false;

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 3) {
                    threeCount ++;
                    if(numbers.get(i + 1) == 3) {
                        threeAfterThree = true;
                    }
                }
                else if (numbers.get(i) == 4) {
                    if (threeCount == 0) {
                        fourBeforeThree = true;
                    }
                    fourCount ++;
                }
            }

            if (threeCount != fourCount) {
                return null;
            }
            else if(threeAfterThree) {
                return null;
            }
            else if (fourBeforeThree) {
                return null;
            }
            else {
                int temp;
                int lastFour = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == 3) {
                        int j = lastFour;
                        while (numbers.get(j) != 4) {
                            j++;
                        }
                        temp = numbers.get(i + 1);
                        numbers.set(i + 1, j);
                        numbers.set(j, temp);
                        lastFour = j;
                    }
                }
                return numbers;
            }
        }
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return null;
        }
        else {
            int fourCount = 0;
            int fiveCount = 0;
            boolean fourAfterFour = false;

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 4) {
                    fourCount ++;
                    if(numbers.get(i + 1) == 3) {
                        fourAfterFour = true;
                    }
                }
                else if (numbers.get(i) == 5) {
                    fiveCount ++;
                }
            }

            if (fourCount != fiveCount) {
                return null;
            }
            else if(fourAfterFour) {
                return null;
            }
            else {
                int temp;
                int lastFive = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == 4) {
                        int j = lastFive;
                        while (numbers.get(j) != 5) {
                            j++;
                        }
                        temp = numbers.get(i + 1);
                        numbers.set(i + 1, j);
                        numbers.set(j, temp);
                        lastFive = i + 2;
                    }
                }
                return numbers;
            }
        }
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers.size() != 0) {
            int sumLeft = 0;
            int sumRight = 0;

            for (int number : numbers) {
                sumRight += number;
            }

            for (int number : numbers) {
                sumRight -= number;
                sumLeft += number;
                if (sumLeft == sumRight) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        if (outer == null || inner == null || outer.size() == 0 || inner.size() == 0) {
            return false;
        }
        else {
            int allIn = 0;
            for (int k : inner) {
                for (int i : outer) {
                    if (k == i) {
                        allIn++;
                    }
                }
            }
            return allIn >= inner.size();
        }
    }

    public ArrayList<Integer> squareUp(int n) {
        if(n < 0) {
            return null;
        }
        else {
            int squaredLength = n * n;
            ArrayList<Integer> squareUp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                for (int i = n; i > 0 ; i--) {
                    if (i >= (j + 2)) {
                        squareUp.add(0);
                    }
                    else {
                        squareUp.add(i);
                    }
                }
            }
            return squareUp;
        }
    }

    public ArrayList<Integer> seriesUp(int n) {
        if (n < 0) {
            return null;
        }
        else {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    numbers.add(j);
                }
            }
            return numbers;
        }
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }
        else {
            int count = 0;
            int start;
            int end;
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = numbers.size() - 1; j > 0; j--) {
                    if (numbers.get(i).equals(numbers.get(j))) {
                        start = i;
                        end = j;
                        count = 1;
                        while(start > 0 && end < numbers.size() && numbers.get(start).equals(numbers.get(end))) {
                            start --;
                            end ++;
                            count ++;
                        }
                    }
                }
            }
            return count;
        }
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }
        else {
            int count = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i).equals(numbers.get(i + 1))) {
                    while(i < numbers.size() - 1 && numbers.get(i).equals(numbers.get(i + 1))) {
                        i++;
                    }
                    count ++;
                }
            }
            return count;
        }
    }

}
