import os

def parse_input(f):
    list_1 = []
    list_2 = []
    for line in f:
        numbers = line.split("   ")
        second_num = numbers[1].split('\n')
        list_1.append(int(numbers[0]))
        list_2.append(int(second_num[0]))
    
    list_1.sort()
    list_2.sort()
    #print(list_1)
    #print(list_2)
    return list_1, list_2

def part_1(list_1, list_2):
    diff = 0
    for idx, num in enumerate(list_1):
        num_2 = list_2[idx]
        
        diff += abs(num - num_2)

    return diff

def part_2(list_1, list_2):
    similarity_score = 0
    for idx, num in enumerate(list_1):
        amt = 0
        for num_2 in list_2:
            if num_2 > num:
                break
            elif num_2 == num:
                amt = amt + 1

        similarity_score += amt * num        
        

    return similarity_score

def main():
    f = open("input/day01.txt")
    l1, l2 = parse_input(f)
    res_1 = part_1(l1, l2)
    res_2 = part_2(l1, l2)
    print(res_1)
    print(res_2)
if __name__ == "__main__":
    main()