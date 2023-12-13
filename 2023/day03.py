import math

def check_parts(min, max, arr, index):
    l = arr[index]
    left = (min == 0)
    right = (max == (len(l) - 1))
    top = (index == 0)
    bottom = (index == len(arr) - 1)
    part = False
    ind = 0
    bot_ind = 0
    # print("left: "+str(left)+" right: "+str(right)+ " top: "+str(top)+ " bot: "+str(bottom))
    for i in range(min, max + 1):
        if(not part):
            if(not top):
                c = arr[index - 1][i]
                part = part or ((c != '.') and not c.isdigit())
                if (((c != '.') and not c.isdigit())):
                    ind = index - 1
                    bot_ind = i
                    # print(str(c)+ " is part: "+str((c != '.') and not c.isdigit()) +" at pos: "+str(index -1 )+ ","+ str(i))
            if(not bottom):
                c = arr[index + 1][i]
                part = part or ((c != '.') and not c.isdigit())
                if (((c != '.') and not c.isdigit())):
                    ind = index + 1
                    bot_ind = i
                    # print(str(c)+ " is part: "+str((c != '.') and not c.isdigit()) +" at pos: "+str(index+1)+ ","+ str(i))
            if(not left):
                c = arr[index][i-1]
                part = part or ((c != '.') and not c.isdigit())
                if (((c != '.') and not c.isdigit())):
                    ind = index 
                    bot_ind = i - 1
                    # print(str(c)+ " is part: "+str((c != '.') and not c.isdigit()) +" at pos: "+str(index)+ ","+ str(i-1))
                if(not top):
                    c = arr[index - 1][i-1]
                    part = part or ((c != '.') and not c.isdigit())
                    if (((c != '.') and not c.isdigit())):
                        ind = index - 1
                        bot_ind = i - 1
                        # print(str(c)+ " is part: "+str((c != '.') and not c.isdigit()) +" at pos: "+str(index-1)+ ","+ str(i-1))
                if(not bottom):
                    c = arr[index + 1][i-1]
                    part = part or ((c != '.') and not c.isdigit())
                    if (((c != '.') and not c.isdigit())):
                        ind = index + 1
                        bot_ind = i - 1
                        # print(str(c)+ " is part: "+str((c != '.') and not c.isdigit()) +" at pos: "+str(index-1)+ ","+ str(i+1))
            if(not right):
                c = arr[index][i+1]
                part = part or ((c != '.') and not c.isdigit())
                if (((c != '.') and not c.isdigit())):
                    ind = index
                    bot_ind = i + 1
                    print(str(c)+ " is part: "+str((c != '.') and not c.isdigit()) +" at pos: "+str(index)+ ","+ str(i+1))
                if(not top):
                    c = arr[index - 1][i+1]
                    part = part or ((c != '.') and not c.isdigit())
                    if (((c != '.') and not c.isdigit())):
                        ind = index - 1
                        bot_ind = i + 1
                        # print(str(c)+ " is part: "+str((c != '.') and not c.isdigit()) +" at pos: "+str(index-1)+ ","+ str(i+1))
                if(not bottom):
                    c = arr[index + 1][i+1]
                    part = part or ((c != '.') and not c.isdigit())
                    if (((c != '.') and not c.isdigit())):
                        ind = index + 1
                        bot_ind = i + 1
                        # print(str(c)+ " is part: "+str((c != '.') and not c.isdigit()) +" at pos: "+str(index+ 1)+ ","+ str(i+1))

    
    return part, ind, bot_ind                


def get_result(arr):
    res = []
    for n in range(0, len(arr)):
        l = arr[n]
        min_idx = 0
        max_idx = len(l)
        num = False
        for i in range(0, len(l)):
            c = l[i]
            # print(str(c) + " " +str(c.isdigit())+ " "+ str(min_idx)+ " "+ str(max_idx)+" " +str(i))

            if(c.isdigit() and not num):
                min_idx = i
                num = True
            if(c.isdigit() and num):
                max_idx = i
            if(((not c.isdigit() or i == len(l) -1)and num)):
                num = False
                is_part, x, y = check_parts(min_idx, max_idx, arr, n)
                if(is_part):
                   # print("".join(l[min_idx : max_idx]) + " has part "+str(arr[x][y]) +" at: "+str(x)+" "+str(y))
                    res.append(int("".join(l[min_idx : max_idx + 1])))
    return res 

def get_whole_num(x, y, arr):
    min = 0
    max = len(arr[x])
    l = arr[x]
    # print("N:"+str(x)+ " "+ str(y))
    ri = False
    le = False
    for i in range(0, len(l)):
        left = y - i
        right = y + i
        if(left >= 0 and l[left].isdigit() and not le):
            min = left
       
       #     print("L:"+str(l[left])+ " "+str(min))
        if(left >= 0 and not l[left].isdigit()):
            le = True
        if(right < len(l) and l[right].isdigit() and not ri):
            max = right
      #      print("R:"+str(l[right])+ " "+str(max))
        if(right < len(l) and not l[right].isdigit()):
            ri = True
    # print("".join(l[min : max + 1]))
    # print("--------------------")
    return int("".join(l[min : max + 1]))
    
    

def get_ratio(arr, n, i):

    left = (i == 0)
    right = (i == (len(arr[0]) - 1))
    top = (n == 0)
    bottom = (n == len(arr) - 1)
    nums = []

    if(not top):
        c = arr[n - 1][i]
        if(c.isdigit()):
            nums.append(get_whole_num(n-1, i, arr))
    if(not bottom):
        c = arr[n + 1][i]
        if(c.isdigit()):
            nums.append(get_whole_num(n+1, i, arr))
    if(not left):
        c = arr[n][i-1]
        if(c.isdigit()):
            nums.append(get_whole_num(n, i-1, arr))
        if(not bottom):
            c = arr[n + 1][i-1]
            if(c.isdigit()):
                nums.append(get_whole_num(n+1, i-1, arr))
        if(not top):
            c = arr[n - 1][i-1]
            if(c.isdigit()):
                nums.append(get_whole_num(n-1, i-1, arr))
    if(not right):
        c = arr[n][i+1]
        if(c.isdigit()):
            nums.append(get_whole_num(n, i+1, arr))
        if(not bottom):
            c = arr[n + 1][i+1]
            if(c.isdigit()):
                nums.append(get_whole_num(n+1, i+1, arr))
        if(not top):
            c = arr[n - 1][i+1]
            if(c.isdigit()):
                nums.append(get_whole_num(n-1, i+1, arr))
    if(len(set(nums)) == 2):
        print(set(nums))
        return math.prod(set(nums))
    else:
        return 0



def get_gear(arr):
    res = 0
    for n in range(0, len(arr)):
        l = arr[n]
        num = False
        for i in range(0, len(l)):
            c = l[i]
            if(c == '*'):
                res += get_ratio(arr, n, i)

    return res            


def parse_input(f):
    ARR = []
    for l in f:
       ARR.append(list(l.rstrip()))
       # print(ARR)
    res1 = get_result(ARR)
    res2 = get_gear(ARR)
    return res1, res2
        

def main():
    f = open("input/day03")
    res1, res2 = parse_input(f)
    print("Total sum: "+str(sum(res1)))
    print("Total gear ratios: "+str(res2))

if __name__ == "__main__":
    main()