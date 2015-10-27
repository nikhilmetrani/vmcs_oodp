pushd
setlocal
call setenv
call ant -buildfile build.xml
endlocal
PAUSE
popd
