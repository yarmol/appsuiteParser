Special acc.suite parser, and git logger
--------------
Executable (using maven executable plugin) application to analize big amount of 1c accounting suite dumps.
All dumps (.cf as configuration, or .dt as base file) will be uploaded into temporary bases.
After that, using acc.suite feature to unload .conf files into collection of .txt file, applicatio will unload 
all .conf files from all of temporary bases.
Config files unload into %working_dir@ parameter. Git repo will created here too. 
Every stage of unloading will be commited by git.
So all big amount of dumps will use git system.
