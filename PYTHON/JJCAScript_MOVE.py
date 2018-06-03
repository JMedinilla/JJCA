import glob
import platform
import shutil

folderList = []
fileList = []
fileNames = []

for file in glob.glob("*"):
    if "." not in file:
        folderList.append(file)

for folder in folderList:
    for file in glob.glob(folder + "/*"):
        fileList.append(file)
for file in fileList:
	if platform.system() == "Windows":
		fileNames.append(file.split("\\")[1])
	else:
		fileNames.append(file.split("/")[1])

for index, file in enumerate(fileList):
    shutil.move(file, fileNames[index])
