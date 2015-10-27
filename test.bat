pushd
setlocal
call setenv
call ant -buildfile build.xml test
endlocal
PAUSE
popd
