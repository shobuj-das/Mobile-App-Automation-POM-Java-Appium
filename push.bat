@echo off
:: Get the current branch name
for /f "tokens=*" %%b in ('git branch --show-current') do set currentBranch=%%b

:: Prompt for commit message
set /p commitMsg="Enter commit message: "

:: Run Git commands
git add .
git commit -m "%commitMsg%"
git push -u origin %currentBranch%

pause
