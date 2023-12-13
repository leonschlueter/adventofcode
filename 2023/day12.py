
def check_solution(s,p):
    p_idx = 0
    num = 0
    check = False

    for i in range(0, len(s)):
        if(s[i] == '.'):
            if(check):
                if(p_idx >= len(p) or num != p[p_idx]):

                    return 0
                elif(num == p[p_idx]):
                    p_idx = p_idx + 1
                    num = 0
            check = False
        if(s[i] == '#'):
            num = num + 1
            check = True
    if (p_idx == len(p) and num == 0):
       return 1
    elif (p_idx == len(p) - 1 and (num == p[p_idx])):
        # print("index: "+str(p_idx))
        return 1
    else:
        return 0
    



def find_all_possible_combinations(s, p, free):
    if(len(free) == 0):
        res = check_solution(s,p)
        #if (res == 1):
           # print("CORRECT")
           # print(s)
          #   print(s, file=open('output_d3.txt', 'a'))
          #  print(p, file=open('output_d3.txt', 'a'))
            # print("-----------------")
        return res
    next_index = free.pop(0)
    new_free = free.copy()
    point = s.copy()
    hashtag = s.copy()
    point[next_index] = '.'
    hashtag[next_index] = '#'
    res1 = find_all_possible_combinations(point, p, free)
    res2 = find_all_possible_combinations(hashtag, p, new_free)
   # print(str(res1)+ " "+ str(res2))
    tot = res1 + res2
    return tot


def parse_input(f):
    res = 0
    curr = 0
    for l in f:
        sep = l.split(" ")
        pos_str = sep[1].rstrip().split(",")
        pos = [int(i) for i in pos_str] * 5
        springs = list(sep[0])
        springs_q = (springs.copy())
        springs_q.append('?')
        s = springs_q * 4
        s.extend(springs)
        free_indices = []
        for i,j in enumerate(s):
            if j == '?':
                free_indices.append(i)
        print("currently working on: "+str(curr))
        res += find_all_possible_combinations(s, pos, free_indices)
      
        curr = curr + 1
    return res
        

def main():
    f = open("input/test_day03")
    s = parse_input(f)
    print("sum: "+  str(s))

if __name__ == "__main__":
    main()