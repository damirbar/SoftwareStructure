##################################### Version 2 #######################################
#
#  The Java hashcode algorithm is taken
#  from here:
#  http://garage.pimentech.net/libcommonPython_src_python_libcommon_javastringhashcode/
#
#######################################################################################

import json

#  The Java hashcode algorithm
def java_hashcode(s):
    h = 0
    for c in s:
        h = (31 * h + ord(c)) & 0xFFFFFFFF
    return str(((h + 0x80000000) & 0xFFFFFFFF) - 0x80000000)


j_output_obj = [] #  An empty list to obtain the information from the JSON array

with open('j.json', 'r') as json_arr:    #  Get the JSON array to the variable "input_arr"
    input_arr = json.load(json_arr)
    
for i in range(len(input_arr)):          #  Appending the user name and hashed password to the list
    name   = input_arr[i]['username']    #  Obtain the username
    password = input_arr[i]['password']  #  Obtain the password
    j_output_obj.append(name+':'+java_hashcode(password))

print(j_output_obj)                        #  Checking manually the gathered information

json_obj = json.dumps({'users': j_output_obj})  #  Wrapping the produced list

print(json_obj)                                 #  Checking manually the validity of the produced JSON

with open('users.json', 'w') as users:     #  Writing the product to a JSON document
    users.write(json_obj)

