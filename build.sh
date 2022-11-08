rm -r src/main/resources/META-INF/resources
cd personalfin
echo "Running npm install"
npm install
echo "Running build"
npm run build
echo "Build successfully"
echo "Making copying files"
mkdir "../src/main/resources/META-INF/resources/"
cp -r build/* ../src/main/resources/META-INF/resources/
echo "Files copied successfully"