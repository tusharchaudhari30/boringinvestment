rm -r personalfinbackend/src/main/resources/static/*
cd personalfin
echo "Running npm install"
npm install
echo "Running build"
npm run build
echo "Build successfully"
cd ..
echo "Making copying files"
cp -r personalfin/build/static personalfinbackend/src/main/resources/static/
cp personalfin/build/index.html personalfinbackend/src/main/resources/templates/index.html
echo "Files copied successfully"
cd personalfinbackend
echo "building gradle"
gradle clean build jacocoTestReport jacocoTestCoverageVerification