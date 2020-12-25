javac -d . EToTilda.java
pushd ..
./gradlew jar
cat customblock/input.txt | java -classpath ./build/libs/assign4.jar:customblock ui.LogicalProcessorUI