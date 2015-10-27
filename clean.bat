pushd
setlocal
call setenv
call ant -buildfile build.xml clean
endlocal
PAUSE
popd
